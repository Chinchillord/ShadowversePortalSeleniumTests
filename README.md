This project is a collection of Selenium tests for the Shadowverse Portal webpage. Shadowverse Portal is a website that facilitates research and deckbuilding for the digital card game, Shadowverse. As I was working on deck construction, I realized that Shadowverse Portal's deckbuilder would be a really fun web app to write some automation code for, so I decided to build a project that would automate the process of constructing a deck, and along with this, I added a few other tests.

The stories tested in this project are as follows:

1. As a user, I am presented with cards from the most recent expansion when I access the homepage

2. As a user, I am given the option to log in to Shadowverse Portal using the social media platform of my choice.

3. As a user, I am able to construct a custom deck using the Shadowverse Portal deckbuilder page.

For stories 1 and 3, the tests are written in a parameterized fashion so that the story can be tested for each of Shadowverse's classes (not to be confused with Java classes). For story 2, logins are tested with Facebook, Twitter, and Google/Gmail. Additionally, the test case verifies that after logging in, the user is brought to their profile page.

To keep track of decklists and current card lists for stories 1 and 3, a Postgresql database is used. The database is fairly simple, containing each card's name, class (in-game class), and, in the case of story 3, the count of the cards in the deck. This database is hosted on AWS and was created using the RDS service.

For story 3, after building the deck using Shadowverse Portal's deckbuilder, we then check that the order and count of the cards matches the decklist pulled from the database.
