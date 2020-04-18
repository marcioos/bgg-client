# bgg-client
BoardGameGeek API 2 client for Java and Android apps

## Adding the library as a dependency

**Gradle**
```
implementation 'com.github.marcioos:bgg-client:1.0'
```

**Maven**
```
<dependency>
    <groupId>com.github.marcioos</groupId>
    <artifactId>bgg-client</artifactId>
    <version>1.0</version>
</dependency>
```

## Javadocs
http://marcioos.github.io/bgg-client/

## Using the library
There's a single class called `BGG` that exposes the 3 main client operations as static methods: `search`, `fetch` and `fetchCollection`.

### Search
Use `BGG.search` for searching items based on a free text search term and an optional list of `ThingType` (var-arg).

```java
SearchOutput searchResult = BGG.search("dominion", ThingType.BOARDGAME);
```

`SearchOutput` contains a list of `SearchItem` along with summary information on the search result. See [SearchOutput](http://marcioos.github.io/bgg-client/com/github/marcioos/bggclient/search/domain/SearchOutput.html) and [SearchItem](http://marcioos.github.io/bgg-client/com/github/marcioos/bggclient/search/domain/SearchItem.html).

### Fetch
Use `BGG.fetch` to retrieve more detailed information about specific items, looking up by their BoardGameGeek database IDs, which can be found with the `BGG.search` method above.

```java
int agricolaXDeckId = 38733;
int dieMacherId = 1;

Collection<FetchItem> item = BGG.fetch(Arrays.asList(agricolaXDeckId, dieMacherId));
```

`FetchItem` contains most of the data available on BoardGameGeek related to an item. See [FetchItem](http://marcioos.github.io/bgg-client/com/github/marcioos/bggclient/fetch/domain/FetchItem.html).

### Fetch collection
Use `BGG.fetchCollection` for retrieving an user's collection by their username on BoardGameGeek.

```java
String username = "marcio_os";

UserCollection myCollection = BGG.fetchCollection(username);
```

See [UserCollection](http://marcioos.github.io/bgg-client/com/github/marcioos/bggclient/fetch/domain/UserCollection.html).
