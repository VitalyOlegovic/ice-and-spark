package it.codegardenroma

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame

object Spark01HelloWorld{

    val bestPlayers = List(
        ChessPlayer("Magnus Carlsen", 2847),
        ChessPlayer("Fabiano Caruana", 2820),
        ChessPlayer("Ding Liren", 2799)
    )

    def main(args: Array[String]) = {
        val spark = SparkSession
            .builder()
            .appName("SparkHelloWorld")
            .config("spark.master", "local")
            .getOrCreate()

        import spark.implicits._

        val playersDF: DataFrame = bestPlayers.toDF()
        playersDF.write.json("target/players/json")
        playersDF.write.csv("target/players/csv")

        spark.stop()
    }
}
