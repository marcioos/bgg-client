# bgg-client
BoardGameGeek API 2 client for Java and Android apps

## Building
Since bgg-client is not available on any public maven repository (someone was too lazy to go through the process), you need to build it yourself as a maven artifact and import it in your project.

Run the following on the project root level:
```
./gradlew publish
```

This will create a folder called `local-repo` which is a local maven repo containing the bgg-client artifact.

## Importing it as a Gradle dependency
Once `local-repo` has been created, move it to the root level of your project and add the following to your `build.gradle` file:

```java
def localRepoDir = new File("$rootDir", "local-repo").toURI().toURL()

buildscript {
  repositories {
    // other repos, e.g. jcenter()
    maven { url localRepoDir }
  }
}

repositories {
  // other repos, e.g. jcenter()
  maven { url localRepoDir }
}

dependencies {
  // other project dependencies
  compile('co.yellowbricks:bgg-client:3.0') {
    transitive = true
  }
}
```

## Using the client
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

`SearchOutput` contains a list of `SearchItem` which have a limited amount of information regarding each game. See [SearchItem.java](src/main/java/co/yellowbricks/bggclient/search/domain/SearchItem.java)

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

`FetchItem` contains most of the data available on Board Game Geek regarding a game. See [FetchItem.java](src/main/java/co/yellowbricks/bggclient/fetch/domain/FetchItem.java)

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

See [UserCollection.java](src/main/java/co/yellowbricks/bggclient/fetch/domain/UserCollection.java)
