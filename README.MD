# Android Movie Information  Application 📈
This project has been developed using Kotlin with Jetpack Compose, following a clean and modular design structure to ensure scalability and reusability in the future. It integrates with the MovieAPI to provide real-time movie information 🎬. Featuring multiple components designed to handle different aspects of the application, it emphasizes modularity and code reuse.


## Code Version Strategy :octocat: 📚

Git Flow was employed as a best programming practice for feature management, utilizing three entities: **`feature branches`**, the **`develop branch`**, and the **`main branch`**. 
- Feature branches were used for work in progress.
- Once the code was stable, a **`pull request`** was made to the **`develop branch`**, where the integration of new features was tested.
- Finally, if the code was stable, a **`pull request`** was made to the **`main branch`**. The main branch always contains stable and final versions of the code.

## UX/UI📍
 Drawing inspiration from common navigation models found in other applications and adopting data visualization techniques similar to those in popular movie trackers, we ensured familiarity and ease of use for users. Moreover, the interface was crafted to facilitate interaction and navigation in various ways, borrowing design cues from streaming applications and other information-centric platforms. Input validations, friendly messages, and intuitive empty states were integrated to transparently communicate the application's status to users. Additionally, the implementation of alertspromptly and effectively notifies users of important actions, enhancing the overall user experience.

## OffLine Data Saving 📲
The app implemented an offline functionality model where movie information and their images are cached locally on the user's device using a Room database. This approach ensures that once the information is synchronized, it is stored locally for future use in case of no internet connection. This not only provides users with access to movie data even when offline but also enhances performance by reducing the need for frequent network requests.

## Demo 🚀

You can see a demo for [Android](), or download both from this repository in the file `demos.zip`

## Application Structure 🏗️

The Film App is structured into several key components, each responsible for a distinct part of the application's functionality:

- **Navigation**: The app provides support for multiple navigation. In this first version, there was included a main stack navigator that uses a bottom tab navigator to display the main screen. This was designed this way considering the addition of Auth features (to be handled by a separate navigator) later on.
  
- **Store**: It saves and maintains the latest information for movies and watchlist.

- **Localization**: Different directories to save and implement the necessary text inside the application. This was implemented considering scalability for multi-language support.

- **Types**: Type management and interface design to make communication between components and services easier.

## Technologies Used 📱

- **Jetpack Compose**: Jetpack Compose is a modern toolkit for building native Android UI. It simplifies and accelerates UI development on Android by providing a declarative way to create UI components.
- **Kotlin**: Secure, concise, and interoperable programming language backed by Google for Android development.
 

## Categories and Sections 🗂️

The application lists the following categories:
- Popular 🚀
- Now Playing 🎬
- Top Rated 📈
- Upcoming 🛒

## Questions
### 1. What does the single responsibility principle consist of? What's its purpose?
The Single Responsibility Principle basically says that each piece of code should only do one thing. in other words, "Keep it simple".This helps make the code easier to understand, change, and fix. So, instead of cramming a bunch of stuff into one class or module, we should split it up into smaller pieces, each handling its own job. This makes the code more organized, less messy, and easier to work with in the long run.

### 2. What characteristics does, in your opinion, a “good” code or clean code have?
In my opinion, a "good" code is the one which is  easy to read and understand because everything is organized. Clean code is basically divided into clear parts, and follows good programming practices. It adheres to standards or rules that make it easier to read and understand. 

###### Overall, I belive clean code is all about being simple, organized, and easy to work with.

### 3. Detail how you would do everything that you have not completed.

- ##### Unit Testing:
 I would complete unit tests using **`JUnit`** and **`Compose Test`** to validate the behavior of key UI components, and I would also implement regression tests to ensure application stability during development. 
- ##### Enhancements:
 I would dedicate more efforts to implementing a login system and storing user data in remote databases, while also working on enhancing visual aspects such as custom themes, animations, and transitions for a more appealing and cohesive user experience.
## Credits 
Special thanks to [theMovieDb](https://www.themoviedb.org/) for providing free access to their API. For more information on the theMovieDb API, visit their [documentation](https://developers.themoviedb.org/).
