println(io.StdIn.readLine.scanLeft(0) {
	case (cur, '(') => cur + 1
	case (cur, ')') => cur - 1
}.indexOf(-1))
