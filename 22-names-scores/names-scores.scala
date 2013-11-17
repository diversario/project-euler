val names = scala.io.Source.fromFile("./names.txt")
          .mkString
          .replace("\"", "")
          .split(",")
          .toList
          .sortWith(_ < _)

val alphaValue = names.map(x => x.map(y => y.toInt - 64).sum)

val scores = alphaValue.zipWithIndex
              .map(e => e._1 * (e._2 + 1))

System.out.println(scores.sum)
