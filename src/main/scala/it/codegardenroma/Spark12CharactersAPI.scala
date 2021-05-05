package it.codegardenroma
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.functions._

object Spark12CharactersAPI{
    def main(args: Array[String]) : Unit = {
        val spark: SparkSession = SparkSession
            .builder()
            .appName(this.getClass().toString())
            .config("spark.master", "local")
            .getOrCreate()

        import spark.implicits._

        val charactersDF = spark.read.json("src/main/resources/characters.json")

        val filteredCharacters = charactersDF
            .select(col("name"),col("born"),col("died"))
            .filter(col("name").isNotNull && col("name") =!= "" && col("born") =!= "")

        val filteredCharacters2 = charactersDF
            .select( $"name", $"born", $"died" )
            .filter( $"name".isNotNull && $"name" =!= "" && $"born" =!= "")

        //val fieldsDF = spark.sql("select name, born, died from characters where name is not null and name!='' and born != ''")
        //fieldsDF.show(5)
        //fieldsDF.write.csv("target/characters/csv")
    }
}