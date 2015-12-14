val number = raw"-?\d+".r

val objekt = raw"\{[^{}]+\}".r
val forbidden = """:\s*"red"""".r.unanchored

def sum(s: String) =
	number.findAllIn(s).map(_.toInt).sum
	
def simplify(s: String) =
	objekt.replaceAllIn(s, _.matched match {
		case forbidden() => "0"
		case str => sum(str).toString
	})
	
var line = io.StdIn.readLine
while(number.unapplySeq(line).isEmpty)
	line = simplify(line)
	
println(line)
