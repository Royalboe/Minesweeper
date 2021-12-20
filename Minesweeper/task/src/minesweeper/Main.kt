package minesweeper

import kotlin.random.Random

const val ROWS = 9
const val COLUMNS = 9
const val MINES = 'X'
const val SAFECELLS = '.'

fun main() {
    println("How many mines do you want on the field?")
    val input = readLine()!!.toInt()
    val mines = Mines(input)
    mines.processMines()
}

// A class to create an instance of a field containing a number of mines stated by the player
class Mines(private var input: Int) {

    // A 2-D list to represent the minefield
    private val mineField = MutableList(ROWS) { MutableList(COLUMNS) { SAFECELLS } }

    fun processMines() {
        while (input > 0) {
            val iRows = Random.nextInt(0, ROWS)
            val iColumns = Random.nextInt(0, COLUMNS)
            if (mineField[iRows][iColumns] != MINES) {
                mineField[iRows][iColumns] = MINES
                input--
            }
        }
        for (index in mineField.indices) {
            printRow(mineField, mineField[index], index)
        }
    }

    private fun printRow(field: MutableList<MutableList<Char>>, list: MutableList<Char>, index: Int) {
        var count = 0
        for (columnIndex in list.indices) {
            if (isMine(field, index, columnIndex)) {
                print(list[columnIndex])
                continue
            }

            if (isMine(field, index - 1, columnIndex - 1)) count++
            if (isMine(field, index - 1, columnIndex + 1)) count++
            if (isMine(field, index - 1, columnIndex)) count++
            if (isMine(field, index + 1, columnIndex - 1)) count++
            if (isMine(field, index + 1, columnIndex + 1)) count++
            if (isMine(field, index + 1, columnIndex)) count++
            if (isMine(field, index, columnIndex - 1)) count++
            if (isMine(field, index, columnIndex + 1)) count++
            if (count > 0 && list[columnIndex] != MINES) {
                print(count)
            } else print(list[columnIndex])
            count = 0
        }
        println()
    }

    // Check for the index to not throw the indexOutOfBounds error
    private fun isMine(field: MutableList<MutableList<Char>>, rowIndex: Int, columnIndex: Int): Boolean {
        return if (
            rowIndex == -1
            || rowIndex == field.size
            || columnIndex == -1
            || columnIndex == field[rowIndex].size
        ) {
            false
        } else {
            field[rowIndex][columnIndex] == MINES
        }
    }
}