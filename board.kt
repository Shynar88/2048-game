

class Board {
  val random = java.util.Random()
  private val a = Array<Array<Int>>(4) { arrayOf(0, 0, 0, 0) } 

  private fun displayRow(s: StringBuilder, row: Int, 
			 form: String?, term: String) {
    for (col in 0 until 4) {
      if (form == null) {
	val m = a[row][col]
	if (m != 0) {
	  var ms = "   " + m.toString()
	  ms = ms.substring(ms.length - 3)
	  s.append(if (m < 1000) "|$ms " else "|$m")
	} else
	  s.append("|    ")
      } else
	s.append(form)
    }
    s.append(term)
    s.append('\n')
  }

  override fun toString(): String {
    val s = StringBuilder()
    for (row in 0 .. 3) {
      displayRow(s, row, "o----", "o")
      displayRow(s, row, "|    ", "|")
      displayRow(s, row, null, "|")
      displayRow(s, row, "|    ", "|")
    }
    displayRow(s, 3, "o----", "o")
    return s.toString()
  }

  // for debugging and testing
  constructor(vararg contents: Int) {
    if (contents.size != 0) {
      assert(contents.size == 15)
      for (row in 0 until 4)
        for (col in 0 until 4)
          a[row][col] = contents[4 * row + col]
    }
  }  

  // for debugging and testing
  fun toList(): List<Int> = a.flatMap { it.toList() }

  fun cell(row: Int, col: Int): Int = a[row][col]

  // is the board completely filled?
  fun isFull(): Boolean{
    for (row in 0 until a.size){
      for (col in 0 until a[0].size){
        if (a[row][col] == 0) return false
    	}
    }
	return true
  }
  
  
  fun insert() {
    val empty = mutableListOf<Pair<Int,Int>>()
    for (row in 0 until a.size){
      for (col in 0 until a[0].size){
        if (a[row][col] == 0){
          empty.add(row to col)
        }
      }
    }
    val R = random.nextInt(empty.size)
    val r = random.nextInt(101)
    if (0 < r && r < 10) a[empty[R].first][empty[R].second] = 4
    else {a[empty[R].first][empty[R].second] = 2}
  }
	
  fun pushLeft(): Int {
    var barrier = 1
    var p = 0
    for (row in 0 until a.size){
      for (col in 1 until a[0].size){
        if (a[row][col] != 0){
          for (i in col downTo barrier){
            if (a[row][i-1] == 0){ 
              a[row][i-1] = a[row][i]
              a[row][i] = 0
            }
            else if (a[row][i-1] == a[row][i]){ 
              p += 2*a[row][i]
              a[row][i-1] = 2*a[row][i]
              a[row][i] = 0
              barrier ++
              }
            else {
              barrier ++
            }
        }
      }
    }
    barrier = 1
  }
    return p
}

  private fun mirror(){
    var c = Array(4){Array(4){0}}
    for (row in 0 until a.size){
      for (cola in 0 until a[0].size){
        c[row][cola] = a[row][cola]
      }
    }
    var colb = 0
    for (row in 0 until a.size){
      colb = 0
      for (cola in a[0].size-1 downTo 0){
        a[row][cola] = c[row][colb]
        colb += 1
      }
    }
  }
  


  private fun transpose(){
    val b = Array(4){Array(4){0}}
    for (row in 0 until a.size){
      for (cola in 0 until a[0].size){
        b[row][cola] = a[row][cola]
      }
    }
    for (row in 0 until a.size){
      for (col in 0 until a[0].size){
        a[col][row] = b[row][col]
      }
    }
  }

  fun pushRight(): Int {
    mirror()
    val p = pushLeft()
    mirror()
    return p
  }

  fun pushUp(): Int {
    transpose()
    val p = pushLeft()
    transpose()
    return p
  }

  fun pushDown(): Int {
    transpose()
    mirror()
    val p = pushLeft()
    mirror()
    transpose()
    return p
  }

  // pushes in direction ch (in 'lrud')
  // returns number of points
  fun push(ch: Char): Int = when(ch) {
    'l' -> pushLeft()
    'r' -> pushRight()
    'u' -> pushUp()
    'd' -> pushDown()
    else -> 0
  }
}


