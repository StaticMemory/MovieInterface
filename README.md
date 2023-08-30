# MovieInterface
Look up a movie or TV show to find ratings, reviews and other interesting trivia items.


# Getting Started:

To get started, a few credentials are required for the TMDB and Google APIs to be available.
Inside your `applications.properties` file located in src/main/resources, add the values:

`spring.jpa.hibernate.ddl-auto=create`, and change create to update after initial setup

`spring.datasource.url=jdbc:mysql:{URL}/{database_name}` replacing with the respective information

`add spring.datasource.username={username}` and `spring.datasource.password={password}`

`spring.jpa.database=mysql`

`spring.jpa.database-platform=org.hibernate.dialect.MySQL5Dialect`

Within this folder, create a `keyHolder.properties` file, and the line:
`test.home={key}`, where the key is your TMDB api key.

in frontend/movieinterface/api, add the field AuthData.json and write in this file:
`{"ClientID" : {clientID}`

`"ClientSecret" : {clientSecret}`
`}`
where `clientID`, `clientSecret` are strings containing the respective values for your google authentication api credentials
