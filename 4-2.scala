val start = io.StdIn.readLine
val hasher = java.security.MessageDigest.getInstance("MD5")

val result = Iterator.from(1).filter { i =>
	val digest = hasher.digest((start + i).getBytes)
	digest(0) == 0 && digest(1) == 0 && digest(2) == 0
}.next

println(result)
