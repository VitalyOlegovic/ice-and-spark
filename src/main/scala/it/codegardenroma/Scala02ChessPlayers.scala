package it.codegardenroma

import scala.runtime.ScalaRunTime

object Scala02ChessPlayers{

    val bestPlayers = List(
        ChessPlayer("Magnus Carlsen", 2847),
        ChessPlayer("Fabiano Caruana", 2820),
        ChessPlayer("Ding Liren", 2799)
    )

    def main(args: Array[String]): Unit = {
        bestPlayers.foreach(
            player => println(player)
        )
    }
}

case class ChessPlayer(name: String, elo: Int)