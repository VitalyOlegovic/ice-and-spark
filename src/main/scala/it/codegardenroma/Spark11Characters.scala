package it.codegardenroma

import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame

object Spark11Characters{
    def main(args: Array[String]) = {
        val spark: SparkSession = SparkSession
            .builder()
            .appName("Spark01ChessPlayers")
            .config("spark.master", "local")
            .getOrCreate()

        import spark.implicits._

        val charactersDF = spark.read.json("src/main/resources/characters.json")
        charactersDF.createTempView("characters")
        val fieldsDF = spark.sql("select name, born, died from characters where name is not null and name!='' and born != ''")
        fieldsDF.show(5)
        fieldsDF.write.csv("target/characters/csv")
    }
}