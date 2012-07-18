dribbble-java-client
====================

dribbble-java-client is a strongly typed Java library for accessing http://dribbble.com API. The 
library provides support for rate limiting requests. All objects implement the necessary `equals`,
`hashcode` and `toString` methods for easier usage. Also, implemented is the `Comparable` 
interface for comparison and sorting.

The library also exposes a convenience class called `DribbbleInvoker` that may be used to add more 
APIs (should they get added in future and this library looses track). The invoker is rate-limit safe.

Usage
-----

A simple example to use is as under,

```java
DribbbleClient client = new DribbbleClient();

// get info on shot with ID: 1
Shot shot = client.getShot(1);

// get info on this shot's player
Player player = client.getPlayer(shot.getPlayer().getId());

// do more...
```

Pagination Support
------------------

All API methods that support pagination have a corresponding, pagination-aware method available as well. For example,
when fetching comments for a shot you may do,

```java
DribbbleClient client = new DribbbleClient();

CommentList list = getShotComments(1);

// do something with these comments

if(list.getPage() < list.getPages()) {
	list = getShotComments(1, 2); // to get default page 2
	
	// or, may provide the number of results to fetch as well
	list = getShotComments(1, 2, 15);
}

// get more comments
```

The current default for number of results per page is 15 per Dribbble API. Refer http://dribbble.com/api for more
details.

Rate-Limiting and Exceptions
----------------------------

By default, the `DribbbleClient` will throw a `DribbbleApiRateLimitException` run-time exception when the
request rate goes over the board. This makes sure that your client does not need to catch unnecessary exceptions
during invocation. 

In case you wish, you may catch this exception and delay the request to a future time as,

```java

Shot shot = null;
int shotID = 1;

try {
	shot = client.getShot(shotID);
} catch(DribbbleApiRateLimitException e) {
	// wait for a minute
	try {
		Thread.sleep(1000 * 60); // one minute
		
		// go ahead and make the call
		shot = client.getShot(shotID);
	} catch(Exception e) {
		// could not wait
		// do nothing
	}
}
```

If you wish to prevent the code from throwing the `DribbbleApiRateLimitException` exception, you can do so when
creating the client.

```java

DribbbleClient client = new DribbbleClient(false);

```

Any invocations on this client, will not throw the error, but return a `null` back as the result to the API query.

Downloads
---------

You can download the `JAR` from the [Downloads](https://github.com/sangupta/dribbble-java-client/downloads) page.

Alternatively, you may download the builds from `Maven Central` repository using:

```xml
<dependency>
    <groupId>com.sangupta</groupId>
    <artifactId>dribbble-java-client</artifactId>
    <version>1.0.0</version>
</dependency>
```

Dependencies
------------

The library is built and compiled using `Java 1.6`. The library has been tested using both `Java 1.6` and `Java 1.7`.

The library also depends on the following external libraries:

* Google GSON library for working with GSON data
* Apache HttpClient library for accessing the internet

The library uses `java.util.logging.Logger` for logging exceptions while accessing the APIs.

Continuous Integration
----------------------
The library is continuously integrated and unit tested using the *Travis CI system.

Current status of branch `MASTER`: [![Build Status](https://secure.travis-ci.org/sangupta/dribbble-java-client.png?branch=master)](http://travis-ci.org/sangupta/dribbble-java-client)

The library is tested against

* Oracle JDK 7
* Oracle JDK 6
* Open JDK 7
* Open JDK 6

Versioning
----------

For transparency and insight into our release cycle, and for striving to maintain backward compatibility, 
dribbble-java-client will be maintained under the Semantic Versioning guidelines as much as possible.

Releases will be numbered with the follow format:

`<major>.<minor>.<patch>`

And constructed with the following guidelines:

* Breaking backward compatibility bumps the major
* New additions without breaking backward compatibility bumps the minor
* Bug fixes and misc changes bump the patch

For more information on SemVer, please visit http://semver.org/.

License
-------
	
Copyright (c) 2012, Sandeep Gupta

The project uses various other libraries that are subject to their
own license terms. See the distribution libraries or the project
documentation for more details.

The entire source is licensed under the Apache License, Version 2.0 
(the "License"); you may not use this work except in compliance with
the LICENSE. You may obtain a copy of the License at

	http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
