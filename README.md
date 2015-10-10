# genbcode-akka-json4s
POC of broken serialization using akka-http, json4s and activated GenBCode

## Steps to reproduce
1. start using `sbt run`
2. send a POST request: `http POST 127.0.0.1:8080 bar=Foo`

You should get a 400 response as follows:

    HTTP/1.1 400 Bad Request
    Content-Length: 48
    Content-Type: text/plain; charset=UTF-8
    Date: Sat, 10 Oct 2015 21:48:44 GMT
    Server: akka-http/2.4.0
    
    The request content was malformed:
    unknown error
    
## Workaround
There're two different ways to work around this bug

1. In [Main.scala](Main.scala#L14) Comment out the line `{require(bar.nonEmpty, "name is required")}`
2. In [build.sbt](build.sbt#L8) Comment out the new backend `GenBCode`
