# 🎥 ASCIICam

**ASCIICam** is a Java application that captures live video from your webcam and transforms it into real-time ASCII art, displayed directly in your terminal.  
Turn your terminal into a retro art gallery!

---

## ✨ Features

- 📷 **Live Webcam Capture:** Uses your default webcam for real-time video.
- 🎨 **ASCII Art Rendering:** Converts each frame into beautiful ASCII art.
- ⚙️ **Configurable Resolution:** Easily adjust output size for your terminal.
- 🖥️ **Cross-Platform:** Works on Linux, Windows, and macOS.

---

## 🛠️ Requirements

- **Java 8** or higher  
  [Download Java here](https://adoptopenjdk.net/) if you don't have it.
- **Gradle** (optional, for building/running)  
  [Install Gradle](https://gradle.org/install/) or use the included Gradle Wrapper.
- **Webcam** connected to your computer

---

## 📦 Dependencies

This project uses:

- [`webcam-capture`](https://github.com/sarxos/webcam-capture)  
  Java library for accessing webcams:  
  `com.github.sarxos:webcam-capture:0.3.12`

Gradle will automatically download all dependencies for you.

---

## 🚀 Installation & Usage

### 1. Clone the Repository

```sh
git clone https://github.com/yourusername/ASCIICam.git
cd ASCIICam
```

### 2. Build & Run

#### Using Gradle Wrapper (recommended)

```sh
./gradlew run
```

#### Or, if you have Gradle installed

```sh
gradle run
```

### 3. Enjoy!

- The app will open your default webcam and start displaying ASCII art in your terminal.
- To stop, press `Ctrl+C`.

---

## ⚙️ Configuration

- **Resolution:**  
  Change the `width` and `height` variables in [`App.java`](app/src/main/java/org/example/App.java) to fit your terminal size.
- **Character Set:**  
  Modify the `CHARACTERS` string in [`App.java`](app/src/main/java/org/example/App.java) to use your favorite ASCII palette.

---

## 🖼️ Screenshots

<!-- Insert your screenshots here! -->

---

## 📁 Project Structure

```
ASCIICam/
├── app/
│   ├── src/
│   │   └── main/java/org/example/App.java
│   └── build.gradle
├── readme.md
└── ...
```

---

## 📜 License

This project is licensed under the Apache License 2.0.  
See the [LICENSE](https://www.apache.org/licenses/LICENSE-2.0) file for details.

---

**Made with ❤️ for ASCII and Java!**
