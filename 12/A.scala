val number = raw"-?\d+".r

def sum(s: String) =
	number.findAllIn(s).map(_.toInt).sum
	
println(sum(io.StdIn.readLine))
