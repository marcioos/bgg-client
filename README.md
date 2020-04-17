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
`BGG.search` finds items that match a given query string and a list of `ThingType` (var-arg).

```java
@Test
public void shouldReturnCorrectAmountOfDominionGames() throws SearchException {
    SearchOutput items = BGG.search("dominion", ThingType.BOARDGAME);

    assertThat(items.getTotal() > 50, is(true));
}
```

`SearchOutput` contains a list of `SearchItem` which have a limited amount of information regarding each game.

### Fetch
`BGG.fetch` returns objects with more detailed information regarding fetched items.

```java
@Test
public void shouldFetchAgricolaXDeckAndDieMacher() throws FetchException {
    int agricolaXDeckId = 38733;
    int dieMacherId = 1;

    Collection<FetchItem> item = BGG.fetch(Arrays.asList(agricolaXDeckId, dieMacherId));

    assertThat(((ArrayList<FetchItem>) item).get(0).getName(), containsString("Agricola"));
    assertThat(((ArrayList<FetchItem>) item).get(1).getName(), containsString("Macher"));
}
```

`FetchItem` contains most of the data available on Board Game Geek regarding a game.

### Fetch collection
`BGG.fetchCollection` returns an user board game collection.

```java
@Test
public void shouldFetchMyCollection() throws FetchException {
    String myName = "marcio_os";

    UserCollection myCollection = BGG.fetchCollection(myName);

    assertThat(myCollection.getTotalItems(), is(not(0)));
}
```

