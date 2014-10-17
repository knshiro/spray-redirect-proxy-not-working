Project trying to show a scenario for the behavior described on spray google group:
https://groups.google.com/d/msg/spray-user/pYVGtyGxbDw/yg-UOvrlLyEJ

Original message:
Dear Spray team,

I tried to retrieve a web page behind a 301 redirect with a simple spray-client pipeline and have no problem if I set spray.can.host-connector.max-redirects = 5
The problem happens when I try to do the same behind a standard squid proxy where I get an "Invalid URL" response from the proxy.
I checked the logs and it's because the host part in the http request only contains the path and squid has no idea about the host.

Looking at the code I found where this is done, but there is a comment that shows that's a conscious decision.
https://github.com/spray/spray/blob/e5434745fd59d24c76d33a1aa611b0d8394ef4a2/spray-can/src/main/scala/spray/can/HttpManager.scala#L55-L60

I searched a config in squid that would allow that, even if that would go against its statelessness, but I didn't find anything relevant.

So my question is: am I doing something wrong or is this a bug?

Thank you very much in advance,

Ugo
