import org.junit.Assert.*
import org.junit.Test

class Game2048Check {

  private fun assertBoard(b: Board, vararg contents: Int) {
    assertEquals(b.toList(), contents.toList())
  }

  @Test    
  fun boardToString() {
    val b = Board(32, 8, 8, 0, 16, 2, 1024, 0, 8, 4, 128, 0, 2, 0, 0, 0)
    assertEquals(b.toString(), "o----o----o----o----o\n|    |    |    |    |\n| 32 |  8 |  8 |    |\n|    |    |    |    |\no----o----o----o----o\n|    |    |    |    |\n| 16 |  2 |1024|    |\n|    |    |    |    |\no----o----o----o----o\n|    |    |    |    |\n|  8 |  4 |128 |    |\n|    |    |    |    |\no----o----o----o----o\n|    |    |    |    |\n|  2 |    |    |    |\n|    |    |    |    |\no----o----o----o----o\n")
  }

  @Test
  fun leftPushes() {
    var b = Board(0, 2, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0)
    b.pushLeft()
    assertBoard(b, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(2, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b.pushLeft()
    assertBoard(b, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(4, 0, 4, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b.pushLeft()
    assertBoard(b, 8, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(8, 0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b.pushLeft()
    assertBoard(b, 8, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(8, 2, 0, 2, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    b.pushLeft()
    assertBoard(b, 8, 4, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    b = Board(8, 16, 4, 0, 4, 0, 0, 4, 0, 0, 0, 0, 4, 2, 0, 0)
    b.pushLeft()
    assertBoard(b, 8, 16, 4, 0, 8, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0, 0)
    b = Board(8, 16, 4, 0, 8, 0, 0, 2, 0, 0, 0, 0, 4, 2, 0, 0)
    b.pushLeft()
    assertBoard(b, 8, 16, 4, 0, 8, 2, 0, 0, 0, 0, 0, 0, 4, 2, 0, 0)
    b = Board(16, 16, 4, 0, 4, 4, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0)
    b.pushLeft()
    assertBoard(b, 32, 4, 0, 0, 8, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0)
    b = Board(32, 8, 2, 0, 8, 0, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0)
    b.pushLeft()
    assertBoard(b, 32, 8, 2, 0, 8, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0)
    b = Board(32, 8, 2, 0, 8, 0, 0, 0, 4, 0, 0, 0, 2, 2, 0, 0)
    b.pushLeft()
    assertBoard(b, 32, 8, 2, 0, 8, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0)
    b = Board(32, 8, 4, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0)
    b.pushLeft()
    assertBoard(b, 32, 8, 4, 2, 16, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0)
    b = Board(32, 8, 4, 2, 16, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0, 0)
    b.pushLeft()
    assertBoard(b, 32, 8, 4, 2, 16, 0, 0, 0, 0, 0, 0, 0, 4, 2, 0, 0)
    b = Board(32, 8, 4, 2, 16, 0, 0, 0, 0, 0, 0, 0, 4, 2, 2, 0)
    b.pushLeft()
    assertBoard(b, 32, 8, 4, 2, 16, 0, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0)
    b = Board(32, 8, 4, 2, 16, 2, 0, 0, 0, 0, 0, 0, 4, 4, 0, 0)
    b.pushLeft()
    assertBoard(b, 32, 8, 4, 2, 16, 2, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0)
    b = Board(32, 8, 4, 4, 16, 2, 0, 0, 8, 4, 0, 0, 0, 0, 0, 2)
    b.pushLeft()
    assertBoard(b, 32, 8, 8, 0, 16, 2, 0, 0, 8, 4, 0, 0, 2, 0, 0, 0)
    b = Board(32, 8, 8, 0, 16, 2, 0, 0, 8, 4, 0, 0, 2, 0, 2, 0)
    b.pushLeft()
    assertBoard(b, 32, 16, 0, 0, 16, 2, 0, 0, 8, 4, 0, 0, 4, 0, 0, 0)
    b = Board(32, 0, 0, 0, 16, 16, 0, 4, 8, 2, 0, 0, 4, 4, 0, 2)
    b.pushLeft()
    assertBoard(b, 32, 0, 0, 0, 32, 4, 0, 0, 8, 2, 0, 0, 8, 2, 0, 0)
    b = Board(64, 8, 4, 4, 16, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0)
    b.pushLeft()
    assertBoard(b, 64, 8, 8, 0, 16, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(0, 0, 0, 2, 64, 0, 0, 0, 16, 16, 0, 0, 2, 2, 2, 0)
    b.pushLeft()
    assertBoard(b, 2, 0, 0, 0, 64, 0, 0, 0, 32, 0, 0, 0, 4, 2, 0, 0)
    b = Board(2, 0, 0, 2, 64, 0, 0, 0, 32, 0, 0, 0, 4, 2, 0, 0)
    b.pushLeft()
    assertBoard(b, 4, 0, 0, 0, 64, 0, 0, 0, 32, 0, 0, 0, 4, 2, 0, 0)
  }

  @Test
  fun rightPushes() {
    var b = Board(8, 2, 0, 2, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0)
    b.pushRight()
    assertBoard(b, 0, 0, 8, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(0, 2, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2)
    b.pushRight()
    assertBoard(b, 0, 0, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2)
    b = Board(2, 0, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2)
    b.pushRight()
    assertBoard(b, 0, 0, 4, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2)
    b = Board(0, 0, 4, 16, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2)
    b.pushRight()
    assertBoard(b, 0, 0, 4, 16, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2)
    b = Board(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 4, 2, 4, 4)
    b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 16, 0, 4, 2, 8)
    b = Board(2, 2, 2, 16, 0, 4, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0)
    b.pushRight()
    assertBoard(b, 0, 2, 4, 16, 0, 0, 4, 8, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(0, 0, 0, 0, 2, 0, 0, 0, 0, 4, 0, 16, 0, 2, 8, 8)
    b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 4, 16, 0, 0, 2, 16)
    b = Board(0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 4, 4, 0, 0, 2, 32)
    b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 8, 0, 0, 2, 32)
    b = Board(0, 0, 0, 0, 2, 4, 0, 0, 8, 32, 0, 4, 2, 2, 2, 0)
    b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 2, 4, 0, 8, 32, 4, 0, 0, 2, 4)
    b = Board(8, 32, 4, 2, 8, 8, 4, 16, 0, 0, 0, 0, 0, 2, 0, 0)
    b.pushRight()
    assertBoard(b, 8, 32, 4, 2, 0, 16, 4, 16, 0, 0, 0, 0, 0, 0, 0, 2)
    b = Board(8, 32, 8, 2, 2, 16, 0, 16, 0, 2, 0, 2, 0, 0, 0, 0)
    b.pushRight()
    assertBoard(b, 8, 32, 8, 2, 0, 0, 2, 32, 0, 0, 0, 4, 0, 0, 0, 0)
    b = Board(0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 8, 32, 8, 32, 4, 4)
    b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 8, 32, 0, 8, 32, 8)
    b = Board(2, 4, 2, 8, 16, 64, 8, 0, 4, 0, 0, 0, 0, 2, 0, 0)
    b.pushRight()
    assertBoard(b, 2, 4, 2, 8, 0, 16, 64, 8, 0, 0, 0, 4, 0, 0, 0, 2)
    b = Board(0, 0, 4, 0, 0, 16, 0, 0, 2, 2, 4, 0, 8, 16, 64, 4)
    b.pushRight()
    assertBoard(b, 0, 0, 0, 4, 0, 0, 0, 16, 0, 0, 4, 4, 8, 16, 64, 4)
    b = Board(0, 0, 0, 4, 4, 0, 0, 16, 0, 0, 4, 4, 8, 16, 64, 4)
    b.pushRight()
    assertBoard(b, 0, 0, 0, 4, 0, 0, 4, 16, 0, 0, 0, 8, 8, 16, 64, 4)
    b = Board(8, 2, 4, 4, 0, 16, 64, 16, 0, 0, 0, 8, 0, 0, 2, 4)
    b.pushRight()
    assertBoard(b, 0, 8, 2, 8, 0, 16, 64, 16, 0, 0, 0, 8, 0, 0, 2, 4)
    b = Board(0, 8, 2, 8, 0, 16, 64, 16, 0, 0, 0, 8, 2, 0, 2, 4)
    b.pushRight()
    assertBoard(b, 0, 8, 2, 8, 0, 16, 64, 16, 0, 0, 0, 8, 0, 0, 4, 4)
    b = Board(0, 8, 2, 8, 0, 16, 64, 16, 0, 0, 0, 8, 2, 0, 4, 4)
    b.pushRight()
    assertBoard(b, 0, 8, 2, 8, 0, 16, 64, 16, 0, 0, 0, 8, 0, 0, 2, 8)
    b = Board(0, 0, 0, 4, 2, 4, 8, 32, 2, 32, 64, 4, 16, 2, 8, 2)
    b.pushRight()
    assertBoard(b, 0, 0, 0, 4, 2, 4, 8, 32, 2, 32, 64, 4, 16, 2, 8, 2)
    b = Board(4, 2, 8, 4, 16, 4, 64, 32, 0, 32, 8, 4, 0, 2, 2, 2)
    b.pushRight()
    assertBoard(b, 4, 2, 8, 4, 16, 4, 64, 32, 0, 32, 8, 4, 0, 0, 2, 4)
    b = Board(4, 2, 8, 4, 16, 4, 64, 32, 2, 32, 8, 8, 0, 0, 2, 2)
    b.pushRight()
    assertBoard(b, 4, 2, 8, 4, 16, 4, 64, 32, 0, 2, 32, 16, 0, 0, 0, 4)
  }

  @Test
  fun upPushes() {
    var b = Board(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0)
    b.pushUp()
    assertBoard(b, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 2)
    b.pushUp()
    assertBoard(b, 8, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(8, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 8, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(8, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 8, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(8, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 8, 0, 0, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(16, 2, 2, 0, 4, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 16, 4, 2, 0, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    b = Board(0, 0, 16, 8, 0, 4, 8, 2, 0, 0, 0, 2, 0, 2, 0, 0)
    b.pushUp()
    assertBoard(b, 0, 4, 16, 8, 0, 2, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(4, 16, 8, 0, 2, 8, 4, 0, 2, 0, 0, 0, 0, 2, 0, 0)
    b.pushUp()
    assertBoard(b, 4, 16, 8, 0, 4, 8, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0)
    b = Board(4, 16, 8, 0, 4, 8, 4, 0, 2, 2, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 8, 16, 8, 0, 2, 8, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0)
    b = Board(0, 8, 16, 8, 2, 8, 4, 2, 0, 2, 0, 2, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 2, 16, 16, 8, 0, 2, 4, 4, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(2, 32, 8, 0, 2, 8, 0, 0, 0, 2, 0, 0, 2, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 4, 32, 8, 0, 2, 8, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0)
    b = Board(0, 4, 32, 8, 2, 0, 2, 8, 0, 0, 0, 2, 0, 0, 0, 2)
    b.pushUp()
    assertBoard(b, 2, 4, 32, 16, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(2, 4, 32, 16, 0, 0, 2, 4, 2, 0, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 4, 4, 32, 16, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(8, 32, 16, 0, 2, 4, 0, 0, 2, 2, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 8, 32, 16, 0, 4, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0)
    b = Board(8, 32, 16, 0, 4, 4, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0)
    b.pushUp()
    assertBoard(b, 8, 32, 16, 0, 4, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0)
    b = Board(8, 32, 16, 0, 4, 4, 0, 0, 2, 4, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 8, 32, 16, 0, 4, 8, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    b = Board(8, 32, 16, 0, 4, 8, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 8, 32, 16, 0, 8, 8, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0)
    b = Board(8, 32, 16, 0, 8, 8, 0, 0, 4, 2, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 16, 32, 16, 0, 4, 8, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0)
    b = Board(16, 32, 16, 0, 4, 8, 0, 2, 4, 0, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 16, 32, 16, 2, 8, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(16, 32, 16, 2, 16, 0, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 32, 32, 16, 2, 4, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(64, 16, 2, 0, 4, 2, 0, 0, 4, 0, 0, 0, 0, 0, 0, 4)
    b.pushUp()
    assertBoard(b, 64, 16, 2, 4, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    b = Board(2, 0, 0, 0, 4, 0, 0, 0, 32, 8, 2, 0, 64, 8, 4, 0)
    b.pushUp()
    assertBoard(b, 2, 16, 2, 0, 4, 0, 4, 0, 32, 0, 0, 0, 64, 0, 0, 0)
    b = Board(4, 0, 0, 0, 8, 0, 2, 0, 32, 16, 0, 0, 64, 4, 2, 0)
    b.pushUp()
    assertBoard(b, 4, 16, 4, 0, 8, 4, 0, 0, 32, 0, 0, 0, 64, 0, 0, 0)
    b = Board(4, 0, 0, 2, 8, 0, 0, 0, 32, 16, 4, 0, 64, 8, 4, 0)
    b.pushUp()
    assertBoard(b, 4, 16, 8, 2, 8, 8, 0, 0, 32, 0, 0, 0, 64, 0, 0, 0)
    b = Board(4, 16, 8, 2, 16, 2, 0, 0, 32, 0, 2, 0, 64, 2, 0, 0)
    b.pushUp()
    assertBoard(b, 4, 16, 8, 2, 16, 4, 2, 0, 32, 0, 0, 0, 64, 0, 0, 0)
    b = Board(4, 16, 8, 2, 0, 16, 4, 2, 0, 0, 0, 32, 0, 2, 64, 2)
    b.pushUp()
    assertBoard(b, 4, 32, 8, 4, 0, 2, 4, 32, 0, 0, 64, 2, 0, 0, 0, 0)
    b = Board(4, 32, 8, 4, 2, 4, 32, 0, 64, 4, 0, 0, 2, 4, 0, 0)
    b.pushUp()
    assertBoard(b, 4, 32, 8, 4, 2, 8, 32, 0, 64, 4, 0, 0, 2, 0, 0, 0)
    b = Board(4, 32, 8, 4, 0, 2, 8, 32, 2, 0, 64, 4, 0, 0, 0, 4)
    b.pushUp()
    assertBoard(b, 4, 32, 16, 4, 2, 2, 64, 32, 0, 0, 0, 8, 0, 0, 0, 0)
    b = Board(16, 32, 16, 4, 2, 64, 32, 2, 2, 0, 2, 0, 0, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 16, 32, 16, 4, 4, 64, 32, 2, 0, 0, 2, 0, 0, 0, 0, 0)
    b = Board(16, 32, 16, 4, 4, 64, 32, 2, 0, 0, 2, 0, 0, 0, 2, 0)
    b.pushUp()
    assertBoard(b, 16, 32, 16, 4, 4, 64, 32, 2, 0, 0, 4, 0, 0, 0, 0, 0)
    b = Board(16, 32, 16, 4, 4, 64, 32, 2, 4, 2, 0, 0, 2, 0, 0, 0)
    b.pushUp()
    assertBoard(b, 16, 32, 16, 4, 8, 64, 32, 2, 2, 2, 0, 0, 0, 0, 0, 0)
    b = Board(16, 32, 16, 4, 8, 64, 32, 2, 2, 0, 4, 2, 0, 0, 0, 2)
    b.pushUp()
    assertBoard(b, 16, 32, 16, 4, 8, 64, 32, 4, 2, 0, 4, 2, 0, 0, 0, 0)
    b = Board(16, 32, 16, 4, 8, 64, 32, 4, 2, 0, 4, 2, 0, 2, 0, 0)
    b.pushUp()
    assertBoard(b, 16, 32, 16, 8, 8, 64, 32, 2, 2, 2, 4, 0, 0, 0, 0, 0)
    b = Board(64, 16, 8, 2, 8, 64, 32, 4, 0, 0, 0, 4, 0, 0, 2, 0)
    b.pushUp()
    assertBoard(b, 64, 16, 8, 2, 8, 64, 32, 8, 0, 0, 2, 0, 0, 0, 0, 0)
  }

  @Test
  fun downPushes() {
    var b = Board(0, 0, 4, 2, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 4)
    b = Board(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 2, 4, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 8)
    b = Board(2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 8, 0)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 4, 4, 8, 0)
    b = Board(0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 16, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 2, 16, 4)
    b = Board(0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 4, 0, 2, 16, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 16, 8)
    b = Board(0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 4, 16, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 4, 4, 16, 8)
    b = Board(0, 0, 0, 0, 0, 2, 0, 0, 2, 0, 2, 0, 4, 4, 16, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 0, 4, 4, 16, 8)
    b = Board(2, 0, 0, 0, 0, 2, 0, 0, 4, 2, 0, 0, 8, 16, 8, 0)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 2, 0, 0, 0, 4, 4, 0, 0, 8, 16, 8, 0)
    b = Board(0, 0, 0, 2, 4, 0, 0, 0, 8, 0, 0, 0, 8, 16, 8, 0)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 16, 16, 8, 2)
    b = Board(0, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 4, 0, 32, 8, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 2, 32, 8, 2)
    b = Board(0, 2, 0, 0, 0, 0, 0, 4, 0, 0, 0, 4, 2, 32, 8, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 8, 2, 32, 8, 2)
    b = Board(2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 8, 2, 32, 8, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 8, 4, 32, 8, 2)
    b = Board(0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 0, 8, 4, 32, 8, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 8, 4, 32, 8, 2)
    b = Board(0, 2, 4, 16, 2, 4, 32, 2, 0, 0, 0, 2, 0, 0, 0, 0)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 4, 16, 2, 4, 32, 4)
    b = Board(0, 2, 0, 0, 0, 0, 0, 0, 0, 2, 4, 16, 2, 4, 32, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 16, 2, 4, 32, 4)
    b = Board(2, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 16, 2, 4, 32, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 16, 4, 8, 32, 4)
    b = Board(2, 0, 0, 0, 2, 0, 0, 0, 4, 16, 0, 0, 4, 8, 32, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 4, 16, 0, 0, 8, 8, 32, 4)
    b = Board(0, 0, 0, 2, 2, 0, 0, 0, 0, 0, 4, 16, 0, 16, 32, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 4, 16, 2, 16, 32, 4)
    b = Board(0, 0, 0, 0, 0, 0, 0, 2, 2, 0, 4, 16, 2, 16, 32, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 4, 16, 4, 16, 32, 4)
    b = Board(0, 0, 0, 0, 4, 0, 0, 2, 4, 16, 0, 0, 4, 16, 32, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 2, 8, 32, 32, 4)
    b = Board(0, 0, 0, 0, 2, 2, 0, 0, 4, 2, 0, 0, 8, 64, 4, 0)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 2, 0, 0, 0, 4, 4, 0, 0, 8, 64, 4, 0)
    b = Board(0, 0, 0, 0, 4, 0, 2, 0, 8, 0, 0, 0, 8, 64, 4, 0)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 2, 0, 16, 64, 4, 0)
    b = Board(0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 4, 0, 16, 64, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 16, 64, 8)
    b = Board(2, 0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 0, 2, 16, 64, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0, 2, 16, 64, 8)
    b = Board(0, 0, 0, 0, 4, 0, 2, 0, 4, 0, 0, 0, 2, 16, 64, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 2, 0, 2, 16, 64, 8)
    b = Board(2, 0, 0, 0, 2, 0, 0, 0, 8, 4, 0, 0, 2, 16, 64, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 4, 0, 0, 0, 8, 4, 0, 0, 2, 16, 64, 8)
    b = Board(2, 8, 2, 4, 16, 4, 2, 0, 64, 8, 2, 0, 2, 0, 0, 0)
    b.pushDown()
    assertBoard(b, 2, 0, 0, 0, 16, 8, 0, 0, 64, 4, 2, 0, 2, 8, 4, 4)
    b = Board(4, 2, 0, 0, 16, 8, 0, 2, 64, 4, 2, 0, 2, 16, 0, 0)
    b.pushDown()
    assertBoard(b, 4, 2, 0, 0, 16, 8, 0, 0, 64, 4, 0, 0, 2, 16, 2, 2)
    b = Board(0, 2, 0, 8, 0, 16, 8, 2, 0, 0, 64, 4, 0, 2, 16, 4)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 2, 8, 8, 0, 16, 64, 2, 0, 2, 16, 8)
    b = Board(0, 0, 0, 4, 4, 0, 2, 16, 0, 16, 64, 2, 0, 2, 16, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 4, 0, 0, 2, 16, 0, 16, 64, 2, 4, 2, 16, 8)
    b = Board(4, 0, 4, 0, 4, 16, 0, 0, 16, 64, 2, 0, 4, 2, 16, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 8, 16, 4, 0, 16, 64, 2, 0, 4, 2, 16, 8)
    b = Board(0, 0, 0, 4, 4, 8, 16, 8, 0, 16, 64, 2, 4, 2, 16, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 4, 0, 8, 16, 8, 0, 16, 64, 2, 8, 2, 16, 8)
    b = Board(4, 0, 0, 0, 8, 16, 8, 2, 2, 16, 64, 2, 8, 2, 16, 8)
    b.pushDown()
    assertBoard(b, 4, 0, 0, 0, 8, 0, 8, 0, 2, 32, 64, 4, 8, 2, 16, 8)
    b = Board(4, 2, 0, 0, 16, 2, 0, 0, 2, 32, 64, 4, 8, 2, 16, 8)
    b.pushDown()
    assertBoard(b, 4, 0, 0, 0, 16, 4, 0, 0, 2, 32, 64, 4, 8, 2, 16, 8)
    b = Board(8, 2, 2, 0, 4, 32, 8, 0, 2, 32, 64, 2, 16, 4, 2, 8)
    b.pushDown()
    assertBoard(b, 8, 0, 2, 0, 4, 2, 8, 0, 2, 64, 64, 2, 16, 4, 2, 8)
    b = Board(8, 2, 2, 0, 4, 2, 8, 2, 2, 128, 2, 0, 16, 4, 2, 8)
    b.pushDown()
    assertBoard(b, 8, 0, 0, 0, 4, 4, 2, 0, 2, 128, 8, 2, 16, 4, 4, 8)
    b = Board(8, 2, 0, 0, 8, 2, 2, 0, 2, 128, 8, 2, 16, 8, 8, 0)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 16, 4, 0, 0, 2, 128, 2, 0, 16, 8, 16, 2)
    b = Board(0, 0, 0, 0, 16, 4, 2, 0, 2, 128, 2, 0, 16, 8, 16, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 16, 4, 0, 0, 2, 128, 4, 0, 16, 8, 16, 2)
    b = Board(0, 0, 0, 2, 0, 2, 16, 4, 0, 2, 128, 4, 16, 8, 16, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 16, 2, 0, 4, 128, 8, 16, 8, 16, 2)
    b = Board(0, 4, 0, 0, 0, 0, 16, 2, 0, 4, 128, 8, 16, 8, 16, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 16, 2, 0, 8, 128, 8, 16, 8, 16, 2)
    b = Board(0, 0, 0, 0, 0, 2, 16, 2, 0, 8, 128, 8, 16, 8, 16, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 16, 2, 0, 2, 128, 8, 16, 16, 16, 2)
    b = Board(0, 0, 0, 0, 2, 16, 2, 0, 2, 128, 8, 0, 32, 16, 2, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 16, 2, 0, 4, 128, 8, 0, 32, 16, 2, 2)
    b = Board(4, 0, 2, 0, 16, 2, 0, 0, 4, 128, 8, 0, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 4, 0, 0, 0, 16, 2, 2, 0, 4, 128, 8, 0, 32, 16, 4, 2)
    b = Board(0, 0, 0, 4, 2, 16, 2, 4, 0, 4, 128, 8, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 16, 2, 8, 2, 4, 128, 8, 32, 16, 4, 2)
    b = Board(0, 2, 0, 0, 0, 16, 2, 8, 2, 4, 128, 8, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 0, 2, 0, 0, 0, 16, 2, 0, 2, 4, 128, 16, 32, 16, 4, 2)
    b = Board(2, 2, 0, 0, 16, 4, 0, 0, 2, 4, 128, 16, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 2, 0, 0, 0, 16, 2, 0, 0, 2, 8, 128, 16, 32, 16, 4, 2)
    b = Board(2, 2, 0, 0, 16, 2, 0, 0, 2, 8, 128, 16, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 2, 0, 0, 0, 16, 4, 0, 0, 2, 8, 128, 16, 32, 16, 4, 2)
    b = Board(0, 0, 4, 2, 0, 16, 4, 2, 2, 8, 128, 16, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 16, 8, 4, 2, 8, 128, 16, 32, 16, 4, 2)
    b = Board(0, 0, 0, 0, 2, 16, 8, 4, 2, 8, 128, 16, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 16, 8, 4, 4, 8, 128, 16, 32, 16, 4, 2)
    b = Board(2, 0, 0, 0, 16, 8, 4, 2, 4, 8, 128, 16, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 2, 0, 0, 0, 16, 0, 4, 2, 4, 16, 128, 16, 32, 16, 4, 2)
    b = Board(2, 0, 0, 0, 16, 2, 4, 2, 4, 16, 128, 16, 32, 16, 4, 2)
    b.pushDown()
    assertBoard(b, 2, 0, 0, 0, 16, 0, 4, 2, 4, 2, 128, 16, 32, 32, 4, 2)
    b = Board(2, 2, 0, 0, 16, 2, 4, 2, 4, 2, 128, 16, 64, 4, 2, 0)
    b.pushDown()
    assertBoard(b, 2, 0, 0, 0, 16, 2, 4, 0, 4, 4, 128, 2, 64, 4, 2, 16)
    b = Board(4, 0, 4, 0, 16, 2, 4, 0, 8, 128, 2, 0, 64, 4, 2, 16)
    b.pushDown()
    assertBoard(b, 4, 0, 0, 0, 16, 2, 0, 0, 8, 128, 8, 0, 64, 4, 4, 16)
    b = Board(4, 0, 0, 0, 16, 2, 0, 2, 8, 128, 8, 2, 64, 8, 16, 0)
    b.pushDown()
    assertBoard(b, 4, 0, 0, 0, 16, 2, 0, 0, 8, 128, 8, 0, 64, 8, 16, 4)
    b = Board(4, 0, 0, 0, 16, 2, 0, 0, 8, 128, 8, 4, 64, 8, 16, 4)
    b.pushDown()
    assertBoard(b, 4, 0, 0, 0, 16, 2, 0, 0, 8, 128, 8, 0, 64, 8, 16, 8)
    b = Board(0, 0, 4, 2, 2, 0, 16, 2, 0, 8, 128, 8, 64, 8, 16, 8)
    b.pushDown()
    assertBoard(b, 0, 0, 4, 0, 0, 0, 16, 0, 2, 0, 128, 4, 64, 16, 16, 16)
    b = Board(2, 0, 4, 2, 0, 0, 16, 2, 0, 2, 128, 4, 0, 64, 32, 16)
    b.pushDown()
    assertBoard(b, 0, 0, 4, 0, 0, 0, 16, 4, 0, 2, 128, 4, 2, 64, 32, 16)
    b = Board(2, 0, 4, 0, 0, 0, 16, 4, 0, 2, 128, 4, 2, 64, 32, 16)
    b.pushDown()
    assertBoard(b, 0, 0, 4, 0, 0, 0, 16, 0, 0, 2, 128, 8, 4, 64, 32, 16)
    b = Board(4, 2, 4, 2, 64, 16, 8, 0, 4, 128, 16, 0, 32, 2, 0, 4)
    b.pushDown()
    assertBoard(b, 4, 2, 0, 0, 64, 16, 4, 0, 4, 128, 8, 2, 32, 2, 16, 4)
  }

  @Test
  fun points() {
    var b = Board(0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 2, 0, 2, 0, 0, 0)
    var p = b.pushLeft()
    assertBoard(b, 0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0)
    assert(p == 0)
    b = Board(0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 4, 0, 2, 0)
    assertEquals(p, 4)
    b = Board(0, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0, 4, 2, 0, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 4, 2, 0, 4)
    assertEquals(p, 4)
    b = Board(0, 0, 0, 2, 0, 0, 0, 0, 4, 0, 0, 0, 4, 2, 0, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 8, 2, 0, 4)
    assertEquals(p, 8)
    b = Board(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 8, 2, 0, 4)
    p = b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 8, 2, 4)
    assertEquals(p, 4)
    b = Board(0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 4, 0, 8, 2, 4)
    p = b.pushUp()
    assertBoard(b, 2, 8, 2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(2, 8, 2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2)
    p = b.pushLeft()
    assertBoard(b, 2, 8, 2, 8, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0)
    assertEquals(p, 0)
    b = Board(2, 8, 2, 8, 0, 0, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0)
    p = b.pushUp()
    assertBoard(b, 2, 8, 2, 8, 4, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 0)
    b = Board(2, 8, 2, 8, 4, 0, 0, 0, 2, 0, 0, 0, 2, 0, 2, 0)
    p = b.pushUp()
    assertBoard(b, 2, 8, 4, 8, 4, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(2, 8, 4, 8, 4, 0, 0, 0, 4, 0, 0, 0, 0, 2, 0, 0)
    p = b.pushUp()
    assertBoard(b, 2, 8, 4, 8, 8, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(2, 8, 4, 8, 8, 2, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0)
    p = b.pushRight()
    assertBoard(b, 2, 8, 4, 8, 0, 0, 8, 2, 0, 0, 0, 0, 0, 0, 0, 2)
    assertEquals(p, 0)
    b = Board(2, 8, 4, 8, 2, 0, 8, 2, 0, 0, 0, 0, 0, 0, 0, 2)
    p = b.pushUp()
    assertBoard(b, 4, 8, 4, 8, 0, 0, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(4, 8, 4, 8, 0, 0, 8, 4, 4, 0, 0, 0, 0, 0, 0, 0)
    p = b.pushUp()
    assertBoard(b, 8, 8, 4, 8, 0, 0, 8, 4, 0, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(8, 8, 4, 8, 0, 0, 8, 4, 2, 0, 0, 0, 0, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 16, 4, 8, 0, 8, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 16)
    b = Board(16, 4, 8, 0, 8, 4, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0)
    p = b.pushUp()
    assertBoard(b, 16, 8, 8, 0, 8, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(16, 8, 8, 0, 8, 2, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 16, 16, 0, 0, 8, 2, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0)
    assertEquals(p, 16)
    b = Board(16, 16, 0, 0, 8, 2, 0, 0, 2, 0, 2, 0, 2, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 32, 0, 0, 0, 8, 2, 0, 0, 4, 0, 0, 0, 2, 0, 0, 0)
    assertEquals(p, 36)
    b = Board(32, 0, 0, 0, 8, 2, 0, 0, 4, 0, 0, 0, 2, 0, 0, 2)
    p = b.pushLeft()
    assertBoard(b, 32, 0, 0, 0, 8, 2, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0)
    assertEquals(p, 4)
    b = Board(32, 0, 0, 0, 8, 2, 0, 0, 4, 0, 0, 0, 4, 0, 0, 2)
    p = b.pushUp()
    assertBoard(b, 32, 2, 0, 2, 8, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(32, 2, 0, 2, 8, 0, 0, 0, 8, 0, 0, 0, 0, 0, 2, 0)
    p = b.pushUp()
    assertBoard(b, 32, 2, 2, 2, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 16)
    b = Board(32, 2, 2, 2, 16, 0, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 32, 4, 2, 0, 16, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 4)
    b = Board(32, 4, 2, 0, 16, 0, 0, 0, 2, 0, 0, 0, 2, 0, 0, 0)
    p = b.pushUp()
    assertBoard(b, 32, 4, 2, 0, 16, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 4)
    b = Board(32, 4, 2, 0, 16, 0, 0, 0, 4, 0, 2, 0, 0, 0, 0, 0)
    p = b.pushUp()
    assertBoard(b, 32, 4, 4, 0, 16, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 4)
    b = Board(32, 4, 4, 0, 16, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 2)
    p = b.pushRight()
    assertBoard(b, 0, 0, 32, 8, 0, 0, 0, 16, 0, 0, 0, 4, 0, 0, 0, 2)
    assertEquals(p, 8)
    b = Board(0, 0, 32, 8, 0, 0, 0, 16, 0, 0, 0, 4, 2, 0, 0, 2)
    p = b.pushRight()
    assertBoard(b, 0, 0, 32, 8, 0, 0, 0, 16, 0, 0, 0, 4, 0, 0, 0, 4)
    assertEquals(p, 4)
    b = Board(0, 0, 32, 8, 0, 0, 2, 16, 0, 0, 0, 4, 0, 0, 0, 4)
    p = b.pushUp()
    assertBoard(b, 0, 0, 32, 8, 0, 0, 2, 16, 0, 0, 0, 8, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(0, 0, 32, 8, 0, 4, 2, 16, 0, 0, 0, 8, 0, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 32, 8, 0, 0, 4, 2, 16, 0, 8, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 0)
    b = Board(32, 8, 0, 0, 4, 2, 16, 0, 8, 2, 0, 0, 0, 0, 0, 0)
    p = b.pushUp()
    assertBoard(b, 32, 8, 16, 0, 4, 4, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 4)
    b = Board(32, 8, 16, 0, 4, 4, 0, 0, 8, 0, 0, 0, 0, 2, 0, 0)
    p = b.pushUp()
    assertBoard(b, 32, 8, 16, 0, 4, 4, 0, 0, 8, 2, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 0)
    b = Board(32, 8, 16, 0, 4, 4, 0, 0, 8, 2, 0, 0, 0, 2, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 32, 8, 16, 0, 8, 0, 0, 0, 8, 2, 0, 0, 2, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(32, 8, 16, 0, 8, 0, 2, 0, 8, 2, 0, 0, 2, 0, 0, 0)
    p = b.pushUp()
    assertBoard(b, 32, 8, 16, 0, 16, 2, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 16)
    b = Board(32, 8, 16, 2, 16, 2, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 32, 8, 16, 2, 16, 4, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 4)
    b = Board(32, 8, 16, 2, 16, 4, 4, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 32, 8, 16, 2, 16, 8, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 8)
    b = Board(32, 8, 16, 2, 16, 8, 0, 2, 2, 0, 0, 0, 0, 0, 0, 0)
    p = b.pushUp()
    assertBoard(b, 32, 16, 16, 4, 16, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 20)
    b = Board(32, 16, 16, 4, 16, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 32, 32, 4, 0, 16, 2, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 32)
    b = Board(32, 32, 4, 0, 16, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 64, 4, 0, 0, 16, 2, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 68)
    b = Board(64, 4, 0, 0, 16, 2, 2, 0, 4, 0, 0, 0, 0, 0, 0, 0)
    p = b.pushLeft()
    assertBoard(b, 64, 4, 0, 0, 16, 4, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 4)
    b = Board(64, 4, 0, 0, 16, 4, 0, 0, 4, 0, 0, 0, 4, 0, 0, 0)
    p = b.pushUp()
    assertBoard(b, 64, 8, 0, 0, 16, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 16)
    b = Board(64, 8, 0, 0, 16, 0, 0, 0, 8, 0, 0, 0, 0, 0, 2, 0)
    p = b.pushLeft()
    assertBoard(b, 64, 8, 0, 0, 16, 0, 0, 0, 8, 0, 0, 0, 2, 0, 0, 0)
    assertEquals(p, 0)
    b = Board(64, 8, 2, 0, 16, 0, 0, 0, 8, 0, 0, 0, 2, 0, 0, 0)
    p = b.pushRight()
    assertBoard(b, 0, 64, 8, 2, 0, 0, 0, 16, 0, 0, 0, 8, 0, 0, 0, 2)
    assertEquals(p, 0)
    b = Board(0, 64, 8, 2, 0, 0, 0, 16, 0, 0, 0, 8, 2, 0, 0, 2)
    p = b.pushRight()
    assertBoard(b, 0, 64, 8, 2, 0, 0, 0, 16, 0, 0, 0, 8, 0, 0, 0, 4)
    assertEquals(p, 4)
    b = Board(0, 64, 8, 2, 0, 0, 0, 16, 0, 0, 0, 8, 2, 0, 0, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 2, 0, 0, 0, 16, 0, 0, 0, 8, 2, 64, 8, 4)
    assertEquals(p, 0)
    b = Board(0, 2, 0, 2, 0, 0, 0, 16, 0, 0, 0, 8, 2, 64, 8, 4)
    p = b.pushRight()
    assertBoard(b, 0, 0, 0, 4, 0, 0, 0, 16, 0, 0, 0, 8, 2, 64, 8, 4)
    assertEquals(p, 4)
    b = Board(0, 0, 2, 4, 0, 0, 0, 16, 0, 0, 0, 8, 2, 64, 8, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 4, 0, 0, 0, 16, 0, 0, 2, 8, 2, 64, 8, 4)
    assertEquals(p, 0)
    b = Board(0, 0, 2, 4, 0, 0, 0, 16, 0, 0, 2, 8, 2, 64, 8, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 4, 0, 0, 0, 16, 0, 0, 4, 8, 2, 64, 8, 4)
    assertEquals(p, 4)
    b = Board(0, 0, 0, 4, 0, 0, 0, 16, 0, 2, 4, 8, 2, 64, 8, 4)
    p = b.pushLeft()
    assertBoard(b, 4, 0, 0, 0, 16, 0, 0, 0, 2, 4, 8, 0, 2, 64, 8, 4)
    assertEquals(p, 0)
    b = Board(4, 4, 0, 0, 16, 0, 0, 0, 2, 4, 8, 0, 2, 64, 8, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 4, 0, 0, 0, 16, 8, 0, 0, 4, 64, 16, 4)
    assertEquals(p, 28)
    b = Board(0, 0, 0, 0, 4, 2, 0, 0, 16, 8, 0, 0, 4, 64, 16, 4)
    p = b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 4, 2, 0, 0, 16, 8, 4, 64, 16, 4)
    assertEquals(p, 0)
    b = Board(0, 0, 0, 0, 0, 2, 4, 2, 0, 0, 16, 8, 4, 64, 16, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 4, 8, 4, 64, 32, 4)
    assertEquals(p, 32)
    b = Board(0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 4, 8, 4, 64, 32, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 2, 0, 4, 4, 8, 4, 64, 32, 4)
    assertEquals(p, 4)
    b = Board(0, 0, 0, 0, 0, 0, 2, 2, 0, 4, 4, 8, 4, 64, 32, 4)
    p = b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 8, 8, 4, 64, 32, 4)
    assertEquals(p, 12)
    b = Board(0, 0, 0, 0, 0, 0, 0, 4, 0, 2, 8, 8, 4, 64, 32, 4)
    p = b.pushRight()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 2, 16, 4, 64, 32, 4)
    assertEquals(p, 16)
    b = Board(0, 0, 0, 0, 0, 0, 2, 4, 0, 0, 2, 16, 4, 64, 32, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 4, 16, 4, 64, 32, 4)
    assertEquals(p, 4)
    b = Board(0, 0, 0, 2, 0, 0, 0, 4, 0, 0, 4, 16, 4, 64, 32, 4)
    p = b.pushLeft()
    assertBoard(b, 2, 0, 0, 0, 4, 0, 0, 0, 4, 16, 0, 0, 4, 64, 32, 4)
    assertEquals(p, 0)
    b = Board(2, 0, 0, 0, 4, 0, 0, 0, 4, 16, 2, 0, 4, 64, 32, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 2, 0, 0, 0, 4, 16, 2, 0, 8, 64, 32, 4)
    assertEquals(p, 8)
    b = Board(0, 0, 0, 0, 2, 0, 0, 0, 4, 16, 2, 4, 8, 64, 32, 4)
    p = b.pushDown()
    assertBoard(b, 0, 0, 0, 0, 2, 0, 0, 0, 4, 16, 2, 0, 8, 64, 32, 8)
    assertEquals(p, 8)
    b = Board(0, 0, 0, 0, 2, 0, 2, 0, 4, 16, 2, 0, 8, 64, 32, 8)
    p = b.pushUp()
    assertBoard(b, 2, 16, 4, 8, 4, 64, 32, 0, 8, 0, 0, 0, 0, 0, 0, 0)
    assertEquals(p, 4)
  }
}