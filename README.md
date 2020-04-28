# Computer Science Side Projects

These projects are suited for engineers trying to beef up their computer science fundamentals. They’ll help you learn more about specific aspects of computing, like file transfer and operating systems design. These projects can be particularly useful for self-taught developers who’ve focused more on practical skills than comp sci fundamentals.

### FTP Client (suggested implementation: web, desktop or CLI app).
Build a simple FTP client. As a bonus challenge, support secure file transfer.

### HTTP Server (suggested implementation: any programming language you want to master). 
To understand HTTP deeply, build an HTTP server. There are a number of tutorials available to guide you through the process.

### Build a simple operating system (suggested implementation: any programming language you want to master). 
This is a project that is technically challenging and will deepen your understanding of how computers and operating systems work. You might wish to start with the free (and cleverly named) book, Operating Systems: From 0 to 1.

### Build a web scraper (suggested implementation: any programming language you want to master). 
Build a tool that takes a URL as input and returns the content of the URL as HTML or XML.

### Bandwidth monitor (suggested implementation: live updating CLI tool). 
Build a tool to track how much data you have downloaded or uploaded on the internet. Have it email you a weekly report of your usage. As a bonus challenge, predict peak usage times.

### Implement a cipher (suggested implementation: any programming language you want to master). 
Build a tool that takes a string of text as input and encrypts it using a cipher, such as the Caesar cipher.

### Create a text message downtime alerter (suggested implementation: app hooked up to the Twilio API for sending text messages). 
Create an app that takes a URL as input and sends you a text message when a request to the URL returns a response code other than 200 (OK).

## Personal Finance Side Projects

These projects will help you achieve a practical goal (get a better handle on your finances), while also improving your software engineering skills.

### A net worth calculator and tracker (suggested implementation: CLI, web, or mobile app). 
Build a calculator you can use to track the rise or fall of your net worth on a monthly basis. You can use something like this net worth worksheet from Charles Schwab to guide you. Optional extension: have it send you a 12 month report for the previous year on the first of January each year.

A tax forecaster (suggested implementation: web app). This will be particularly useful if you do any freelance software engineering. Build a tool that takes your freelance earnings as input and then predicts your expected tax liability for the rest of the financial year. Make it smart enough to predict periods of higher or lower demand for your services, and adjust accordingly.

A deal finder (suggested implementation: web app with mobile notifications). Build a simple web app to notify you when an item you covet goes on sale for a good price. You could use a web scraper to pull the item’s product page and notify you of any price changes.

An expense tracker (suggested implementation: web or mobile app). Create a simple interface you can use to add and categorize your expenses. Generate monthly reports based on the inputs and write custom alerts for things, like, “spending too much money on coffee… as always.”

A financial independence calculator (suggested implementation: web app). Financial independence is, essentially, saving and investing as much of your income as possible so that you don’t need to work for money. While many financially independent people continue to work, they can now focus on doing work that they love, rather than work that pays the most. Build a tool to calculate, based on your: current savings, investments, income, retirement accounts, and expenses, how far away you are from financial independence. Some examples: FIREcalc, cFIREsim.

A bill splitter (suggested implementation: mobile app). Build a simple tool to help you and your friends split bills when you go out to eat together.

Games and Simulation Side Projects
Most software engineers I know are fascinated by the world of game development, graphics, and simulations, but don’t have a lot of experience with them. These projects are small enough that you can set foot into this world without biting off more than you can chew.

A random name generator (suggested implementation: CLI, web, or mobile app). Build a random name generator (example) that creates unique names on the fly, based on an algorithm. Use machine learning techniques to help you by training the program with a sample data set of names similar to those you want to generate. Otherwise, create your own lexical rules for how names are generated. For example, a name generating algorithm inspired by The Handmaid's Tale might stipulate that names for Handmaid women should start with 'Of', and end with a random male name, e.g., Ofpeter.

Conway’s Game of Life (suggested implementation: any platform capable of real-time graphical rendering). Conway’s Game of Life simulates the lives of simple cells that obey algorithmic laws. This video explains how the game works and includes an example of one possible result:



A procedurally generated map maker (suggested implementation: browser-based app). Create a browser-based application that allows users to procedurally generate a terrain map based on a random seed. The map can be as detailed or as simple as you’d like. This project is a good opportunity to learn about procedural generation.

A character generator (suggested implementation: browser-based or mobile app, CLI). Create a tool that allows you to randomly generate playable characters for your favorite role-playing games, whether they be tabletop games, like Pathfinder, or video games, like Divinity: Original Sin.

Interactive fiction (suggested implementation: CLI). A fun way to get into game development without having to worry about graphical assets, interactive fiction renders the world for the player through text descriptions. The Dreamhold is a good example of interactive fiction with a useful ‘help’ command.

Artificial Intelligence Side Projects
AI’s usefulness in day-to-day software engineering is increasing by leaps and bounds. It’s now easier than ever before to make your first forays into the world of Artificial Intelligence.

An unbeatable Tic-Tac-Toe engine (suggested implementation: CLI program). For an excellent first AI project, try to write an engine that cannot be beaten at Tic-Tac-Toe. You can achieve this by implementing this strategy, which produces a draw as its worst-case outcome.

A chess engine (suggested implementation: an engine written in a programming language you want to learn, or master). Try to write an engine that can play chess against a human opponent using a Universal Chess Interface compatible GUI, such as XBoard. See Stockfish as an example. For a less daunting challenge, you may wish to focus on the behavior of just one piece, e.g., Knights.

A niche chatbot (suggested implementation: web app). Some of the greatest minds in the world are working on chatbots that respond in lifelike ways. It’s an incredibly difficult challenge, but, by reducing the scope of your chatbot, you have a side project that is more approachable for evenings and weekends. Create a chatbot that produces real-sounding responses based on a niche topic that you’re passionate about: your favorite band, video game, sports team, or TV show. Leverage an existing library to help you, such as ChatterBot.

A spam classifier (suggested implementation: any programming language you want to master). Build a tool to classify whether an email is or isn’t spam based on the content alone. You can use this public data set of emails from the Enron investigation to test your spam classifier.

Entertainment Side Projects
These projects are for software engineers who want to work on something fun and light-hearted.

A movie showtime finder (suggested implementation: web or mobile app with email or text message notifications). Build a program that notifies you, by text or email, about showtimes for potentially interesting movies playing at your favorite cinema. The concept of an 'interesting movie' can be derived using machine learning (if you watch enough movies to have good training data), or a handcrafted algorithm. For example, you might use the Open Movie Database API, paired with an HTML parser like BeautifulSoup, to build a program that alerts you to sci-fi movies rated 7.0 or above on IMDB, movies starring Amy Adams, and/or any movie with an average rating of 8.0 or higher.

A spoiler blocker (suggested implementation: browser extension). Short of implementing a total social media/internet/watercooler chat ban, it can be difficult to avoid seeing spoilers for your favorite TV show… especially if that TV show is as popular as Game of Thrones. Create a browser extension that removes all mentions of your favorite show from any webpage loaded in your browser… or replaces them with cute pictures of puppies.

Fun Side Projects
These projects are all different, from logging sensor data to finding new desktop backgrounds for your computer. One thing they all have in common is that they’re fun, and several of them will have you work with interesting APIs.

Pixel art generator (suggested implementation: any programming language you want to master). Build a tool that takes an image as input and samples the image to produce pixel art as output. If you want to improve your front-end skills, generate the resulting pixel art using CSS.

Music suggestion tool (suggested implementation: build a wrapper for the Spotify API). Create a tool that tracks the music you listen to and generates a playlist with similar qualities, but of songs you haven’t heard before. The Spotify API provides all of the tools needed to extract what you’ve listened to and create a playlist — the recommendation engine is up to you!

Temperature logger (suggested implementation: Raspberry Pi, temperature sensor, web app). Have your Raspberry Pi hooked up to a temperature sensor and send temperature data from your home to a web app that saves the data to a database or updates a CSV file. For bonus points, have a weekly temperature report emailed to you. Other Raspberry Pi projects: home automation, home security.

Microlearning app (suggested implementation: web or mobile app). Build an application that sends you one page per day about something you want to learn. This could be a random page from Wikipedia, a page of React documentation, a Kanji character, or a page from the CIA World Factbook.

Slack bot (suggested implementation: Slack API). If you or your team use the popular chat app Slack, build a bot to make some aspect of your (or your team’s) life easier. Ideas: a coffee order bot, a bot that reports daily on the number of commits made to your team repos, or a daily stand-up reminder bot.

Daily desktop background (suggested implementation: Unsplash API, scripting language for your OS). Build an app that refreshes your desktop background with a new image every day.

Coding Challenge Side Projects
Rather than building a project from scratch, these are collections of coding challenges to improve your skills. If you want to get better at solving discrete problems, or improving your chops with a new programming language, these are all good options.

Advent of Code (suggested implementation: any language you want to practice). Advent of Code challenges occur every year in the days leading up to Christmas. They include lots of fun programming challenges that can help you develop your chops in a programming language you’re learning or one you want to master. The challenges from 2015, 2016, and 2017 are still available.

Kaggle’s Titanic Challenge (suggested implementation: Python or R). Kaggle offers a fascinating challenge to introduce you to the basics of machine learning with Python or R: use a real data set from the Titanic passenger log to predict which passengers were most likely to survive the disaster.

Project Euler (suggested implementation: any programming language you want to practice). Project Euler challenges are dedicated to exploring the marriage between mathematics and programming. Use programming tools to solve various mathematical challenges.

Daily Life Side Projects
These side projects have a practical purpose: they help with some aspect of your daily life. Though they solve simple real-world problems (things like what to have for lunch), the solutions can be as simple, or as complex, as you’d like.

Lunch picker (suggested implementation: CLI, web or mobile app). If you’re a working software engineer, you’ve probably wrestled with one of the toughest questions in software development… where should I have lunch? Your lunch picker is the tool you’ll turn to to answer this question. It can be super simple and pick from a range of options you know you like at random, or more complex — pulling in data from Google Reviews and taking into account: location, price, and type of cuisine.

Date planner (suggested implementation: mobile app). One of the hardest things about dating, or being in a long-term relationship, is deciding where to go on dates. Build a tool that scours restaurant reviews, event calendars, and other data for date idea suggestions.

Tool to simplify your email newsletters (suggested implementation: scripts hooked up to a mail server). If you’re like me, you receive way too many email newsletters every week and they clutter up your inbox. Instead of unsubscribing from all of them in a fit of rage, build a tool that captures these emails and compiles them all into a single email that is sent once a week.

‘Bring your umbrella’ notifier (suggested implementation: mobile app). Build a simple mobile app that sends you a phone notification in the morning telling you if you should bring your umbrella to work (e.g., if it is going to rain in your area that day).

Collection tracker (suggested implementation: web or mobile app). Build a tool to keep track of something you collect. You could keep track of: the value of the item, the year it was made, its condition, and its location.

Data Side Projects
These projects will improve your ability to work with data. Software engineers work with ever-larger amounts of data. These projects will help you learn how to collate, parse, and analyze data with confidence.

Create and automatically update a data set (suggested implementation: web scraper input to CSV output). Build a tool to automatically build and update a data set about something you’re interested in. Suggested data sets: stats about your favorite sports team, flights to destinations you want to visit, meteorological data from where you live, or anything else that interests you. The most important thing is that the data set should require constant updates as new data is generated — and should occur automatically. For example, as soon as your sport’s team’s results are posted on a website, the data should be automatically scraped and added to your data set.

Enter a data science competition (suggested implementation: R or Python). Kaggle hosts a number of data science competitions featuring real-world data sets and hefty cash prizes. You’ll also often be tasked with solving real-world problems like: how to classify toxic online comments, forecast restaurant visitors, or recognize objects from space.

from https://www.codementor.io/@npostolovski/40-side-project-ideas-for-software-engineers-g8xckyxef#computer-science-side-projects