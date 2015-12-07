println(io.StdIn.readLine.map {
	case '(' => 1
	case ')' => -1
}.sum)
