# NIT3213 Final Project: Pet Entity Dashboard Application

## Project Overview
This is an Android application developed for the **NIT3213 Final Assignment**. The app demonstrates proficiency in API integration, user interface design, and Android development best practices. The app interacts with the **vu-nit3213-api** to authenticate users and retrieve a list of entities, which is displayed in a **RecyclerView**. Users can view details for each entity by clicking on them in the dashboard.

## Features
1. **Login Screen**:
    - Users can log in using their first name as the username and their student ID (in the format: `s12345678`) as the password.
    - Upon successful login, users are authenticated and receive a `keypass`, which is used to retrieve the dashboard data.

2. **Dashboard Screen**:
    - Displays a list of entities retrieved from the API.
    - Each entity shows its **name**, **culture**, and **domain**.
    - Clicking on an entity navigates to the Details screen.

3. **Details Screen**:
    - Displays all details of the selected entity, including name, culture, domain, symbol, parentage, Roman equivalent, and description.

## Prerequisites

### System Requirements:
- **JDK 17** from Oracle (make sure to have JDK 17 installed and set as the project SDK).
- Android Studio (latest version).
- Internet connection (required for API calls).

### Installing JDK 17:
1. Download JDK 17 from Oracle's official site: [JDK 17 Downloads](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html).
2. Follow the installation instructions specific to your OS.
3. Set up JDK 17 as your default JDK in Android Studio:
    - Go to **File > Project Structure**.
    - Under **SDK Location**, set the JDK location to the path where you installed JDK 17.
    - Sync the project with Gradle to apply the new SDK.

### Installing Android Studio:
1. Download the latest version of Android Studio from [here](https://developer.android.com/studio).
2. Install Android Studio and set up an emulator or connect a physical device for testing.

## Getting Started

### Clone the Repository
To get a copy of the project up and running on your local machine, clone the repository from GitHub:

```bash
git clone https://github.com/callumforde2002/NIT3213FinalProjectCallumForde

