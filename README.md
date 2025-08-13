# Aksi Untuk Lingkungan - Environmental Action Desktop Application

A JavaFX-based desktop application focused on environmental awareness and community engagement. This application provides a platform for environmental activities including donation management, event scheduling, reporting, and social features.

## 🌱 About The Project

**Aksi Untuk Lingkungan** (Action for Environment) is a comprehensive desktop application designed to promote environmental consciousness and facilitate community participation in environmental protection activities. The application serves as a digital platform for managing donations, scheduling environmental events, sharing reports, and connecting environmentally-conscious individuals.

## 🛠️ Tech Stack

### Core Technologies

- **Java** - Primary programming language
- **JavaFX** - UI framework for desktop application
- **FXML** - XML-based user interface markup language for JavaFX

### Libraries & Dependencies

- **XStream** - XML serialization library for data persistence
  - `com.thoughtworks.xstream.XStream`
  - `com.thoughtworks.xstream.io.xml.StaxDriver`
  - `com.thoughtworks.xstream.security.AnyTypePermission`

### Data Storage

- **XML Files** - Local data persistence using XML format
  - `DaftarAkunPengguna.xml` - User accounts data
  - `DaftarJadwal.xml` - Schedule/events data
  - `listBerita.xml` - News/articles data
  - `ListDonasiBarang.xml` - Item donations data
  - `ListLaporan.xml` - Reports data

### Development Environment

- **VS Code** - Primary IDE
- **Java Projects Extension** - VS Code Java support

## 📁 Project Structure

```
Project-FPA-Oracle/
├── Project FPA RPL/
│   ├── src/
│   │   ├── App.java                          # Main application entry point
│   │   └── TugasBesar/                       # Main package
│   │       ├── MSProject.java                # JavaFX Application class
│   │       ├── OpenScene.java                # Scene navigation utility
│   │       ├── ModelAkun.java                # User account model
│   │       ├── ModelJadwal.java              # Schedule model
│   │       │
│   │       ├── Controllers/                  # FXML Controllers
│   │       ├── FXMLLoginController.java      # Login functionality
│   │       ├── FXMLRegistrasiController.java # User registration
│   │       ├── FXMLHalamanUtamaController.java # Main page
│   │       ├── FXMLDonasiBarangController.java # Item donations
│   │       ├── FXMLDonasiUangController.java  # Money donations
│   │       ├── FXMLLaporanController.java     # Reports management
│   │       ├── FXMLJadwalController.java      # Schedule management
│   │       ├── FXMLSosialController.java      # Social features
│   │       └── ... (other controllers)
│   │       │
│   │       └── FXML Files/                   # UI Layouts
│   │           ├── Login.fxml                # Login interface
│   │           ├── HalamanUtama.fxml         # Main page interface
│   │           ├── Registrasi.fxml           # Registration interface
│   │           ├── DonasiBarang.fxml         # Item donation interface
│   │           ├── DonasiUang.fxml           # Money donation interface
│   │           └── ... (other UI files)
│   │
│   └── bin/                                  # Compiled classes
│
├── Data Files/                               # XML data storage
│   ├── DaftarAkunPengguna.xml               # User accounts
│   ├── DaftarJadwal.xml                     # Events schedule
│   ├── listBerita.xml                       # News articles
│   ├── ListDonasiBarang.xml                 # Item donations
│   └── ListLaporan.xml                      # Reports
│
└── README.md                                # This file
```

## ✨ Features

### 🔐 User Management

- **User Registration** - New user account creation
- **Login System** - Secure user authentication
- **Password Management** - Change password functionality
- **User Profiles** - Account information management

### 💝 Donation Management

- **Item Donations** - Manage physical item donations for environmental causes
- **Money Donations** - Handle monetary contributions
- **Donation Tracking** - View and manage donation history
- **Thank You System** - Acknowledgment for donors

### 📅 Event Scheduling

- **Event Creation** - Add environmental events and activities
- **Schedule Management** - View and organize upcoming events
- **Event Participation** - Register for environmental activities

### 📊 Reporting System

- **Activity Reports** - Generate reports on environmental activities
- **Progress Tracking** - Monitor environmental initiatives
- **Data Visualization** - View statistics and progress

### 🌐 Social Features

- **News Sharing** - Upload and share environmental news
- **Documentation** - Upload photos and documents of environmental activities
- **Community Engagement** - Connect with other environmental enthusiasts

### 📰 News Integration

- **External News Links** - Integration with environmental news sources
- **BBC Indonesia** - Direct links to environmental articles
- **Kompas Lestari** - Access to sustainability news

## 🚀 Getting Started

### Prerequisites

- **Java JDK 8+** - Ensure Java Development Kit is installed
- **JavaFX Runtime** - Required for running JavaFX applications
- **VS Code** (optional) - For development

### Installation

1. **Clone the repository**

   ```bash
   git clone https://github.com/rmdhakbar/Project-FPA-Oracle.git
   cd Project-FPA-Oracle
   ```

2. **Navigate to the project directory**

   ```bash
   cd "Project FPA RPL"
   ```

3. **Compile the application**

   ```bash
   javac -cp "src" src/TugasBesar/MSProject.java
   ```

4. **Run the application**
   ```bash
   java -cp "src" TugasBesar.MSProject
   ```

### Alternative: Using VS Code

1. Open the project folder in VS Code
2. Ensure Java Extension Pack is installed
3. Run the application using VS Code's Java runner

## 💾 Data Persistence

The application uses XML files for data storage:

- **User data** is stored in `DaftarAkunPengguna.xml`
- **Schedule data** is stored in `DaftarJadwal.xml`
- **News data** is stored in `listBerita.xml`
- **Donation data** is stored in `ListDonasiBarang.xml`
- **Report data** is stored in `ListLaporan.xml`

Data is serialized/deserialized using the XStream library for seamless XML operations.

## 🎨 User Interface

The application features a modern JavaFX interface with:

- **Responsive Design** - Adapts to different screen sizes
- **Intuitive Navigation** - Easy-to-use menu system
- **Clean Layout** - Professional and user-friendly design
- **Environmental Theme** - Green-focused color scheme

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 License

This project is part of an academic assignment and is intended for educational purposes.

## 👥 Authors

- **Oracle (E)** - Original Developer
- **Andhika** - Contributor
- **rmdhakbar** - Repository Owner

## 🙏 Acknowledgments

- Environmental organizations for inspiration
- JavaFX community for excellent documentation
- XStream library for XML processing capabilities
- VS Code Java extension team for development tools

## 📞 Support

For support and questions:

- Create an issue in the GitHub repository
- Contact the development team

---

**Made with 💚 for the Environment**

_This application is designed to promote environmental awareness and facilitate community action for environmental protection._
