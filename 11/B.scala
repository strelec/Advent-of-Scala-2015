def inc(s: List[Char]): List[Char] = s match {
	case 'z' :: rest => 'a' :: inc(rest)
	case c :: rest => (c + 1).toChar :: rest
	case Nil => List('a')
}

def threeStraight(s: List[Char]) =
	s.sliding(3).exists { case Seq(a, b, c) =>
		a - b == 1 && b - c == 1
	}


def isPair(s: List[Char]) = s(0) == s(1)

def twoPairs(s: List[Char]) = {
	val pairs = line.sliding(2).toSeq
	pairs.lastIndexWhere(isPair) - pairs.indexWhere(isPair) > 1
}
	

var line = io.StdIn.readLine.reverse.toList
(1 to 2).foreach { _ =>
	line = inc(line)
	while(
		! threeStraight(line) ||
		  line.contains("iol".toSet) ||
		! twoPairs(line)
	) line = inc(line)
}

println(line.reverse.mkString)
