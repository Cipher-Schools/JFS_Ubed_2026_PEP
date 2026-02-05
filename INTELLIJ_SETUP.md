# IntelliJ IDEA Setup Guide

## Prerequisites

- **Java JDK 21 or higher** (JDK 21, 22, 23, 24, 25, etc.)
- IntelliJ IDEA (Community or Ultimate Edition)

## Quick Setup (After Cloning)

Since the `.idea` folder and `JFS-Prep.iml` file are now included in the repository, IntelliJ will automatically load the project configuration. You only need to configure your JDK.

### Step 1: Clone the Repository

```bash
git clone https://github.com/Cipher-Schools/JFS_Ubed_2026_PEP.git
cd JFS_Ubed_2026_PEP
```

### Step 2: Open Project in IntelliJ

1. **File** → **Open**
2. Select the `JFS_Ubed_2026_PEP` folder
3. Click **OK**
4. IntelliJ will automatically recognize the project structure ✅

### Step 3: Configure JDK (Required) - EASIEST METHOD

> **Important**: The project requires **JDK 21 or higher**. It will work with any JDK version from 21 onwards (21, 22, 23, 24, 25, etc.)

**🎯 When you first open the project**, you'll see a **yellow/gold notification bar** at the top of IntelliJ that says:

> **"Project JDK is not defined"** or **"Setup SDK"**

This is the **easiest way** to configure your JDK:

1. **If you already have JDK 21+ installed:**
   - Click **"Setup SDK"** or **"Configure"** in the notification bar
   - A dropdown will appear showing all detected JDKs on your system
   - **Select any JDK 21 or higher** from the list (21, 22, 23, 24, 25, etc.)
   - Click **OK**
   - ✅ Done! The project will start working immediately

2. **If you don't have JDK 21+ installed:**
   - Click **"Download JDK"** in the notification bar
   - Select:
     - **Version**: 21 or higher (21, 22, 23, 24, 25)
     - **Vendor**: Any (Amazon Corretto, Oracle, Eclipse Temurin, etc.)
   - Click **Download**
   - Wait for download to complete
   - ✅ Done! IntelliJ will configure it automatically

**That's it!** Once you've selected or downloaded a JDK, the notification bar will disappear and you can start running your code.

---

### Alternative: Manual JDK Configuration

If the notification bar doesn't appear or you prefer manual configuration:

#### Option A: If you have JDK 21+ installed

1. **File** → **Project Structure** (or `Ctrl+Alt+Shift+S` on Windows, `Cmd+;` on Mac)
2. Click on **Project** (left sidebar)
3. Under **SDK**, click the dropdown:
   - If you see your JDK 21+ listed → Select it
   - If not listed → Click **Add SDK** → **Download JDK** or **Add JDK** (browse to existing installation)
4. Set **Language level** to "21 - Sealed types, always-strict floating-point semantics" (or leave as "SDK default")
5. Click **Apply** → **OK**

#### Option B: Download JDK if you don't have it

1. **File** → **Project Structure** → **Project**
2. Under **SDK**, click **Add SDK** → **Download JDK**
3. Select:
   - **Vendor**: Any (Amazon Corretto, Oracle, Eclipse Temurin, etc.)
   - **Version**: 21 or higher (21, 22, 23, 24, 25)
4. Click **Download**
5. Wait for download to complete
6. Click **Apply** → **OK**

### Step 4: Verify Configuration

1. Check that `src` folder has a **blue icon** (Sources Root) ✅
2. Open any file with a `main` method (e.g., `src/project/demo/LoggerDemo.java`)
3. You should see a **green play button ▶️** next to the class or `main` method ✅

If you see the green play button, you're all set! 🎉

---

## Running Files

### Method 1: Using Green Play Button

1. Open any file with a `main` method
2. Click the **green play button ▶️** next to the class or `main` method
3. Or right-click anywhere in the file → **Run 'ClassName.main()'**

### Method 2: Using Run Menu

1. Open the file you want to run
2. **Run** → **Run 'ClassName'**

IntelliJ will automatically:

- Compile all dependencies
- Set the correct classpath
- Run the program ✅

---

## Troubleshooting

### Issue 1: "Cannot find symbol" or "package does not exist" errors

**Cause**: JDK not configured or `src` not marked as source root.

**Solution**:

1. **File** → **Project Structure** → **Project**
2. Ensure SDK is set to JDK 21+
3. Go to **Modules** → Verify `src` has a **blue icon** (Sources Root)
4. If not blue, select `src` → Click **"Sources"** button at top
5. Click **Apply** → **OK**

### Issue 2: "Invalid source release: 21" or "target release 21 requires source release 21 or later"

**Cause**: You have an older JDK (<21) configured.

**Solution**:

1. **File** → **Project Structure** → **Project**
2. Change SDK to JDK 21 or higher (see Step 3 above)
3. Set **Language level** to "21" or "SDK default"
4. Click **Apply** → **OK**

### Issue 3: No green play button appears

**Cause**: IntelliJ doesn't recognize it as a runnable class.

**Solution**:

1. **File** → **Invalidate Caches / Restart**
2. Select **"Invalidate and Restart"**
3. After restart, check if the play button appears

### Issue 4: `src` folder is not blue (not marked as Sources Root)

**Solution**:

1. Right-click on `src` folder
2. **Mark Directory as** → **Sources Root**
3. The folder should turn blue ✅

---

## Expected Folder Structure in IntelliJ

After proper configuration:

```
📁 JFS_Ubed_2026_PEP
├── 📁 .idea (IntelliJ configuration - already included)
├── 📄 JFS-Prep.iml (Module file - already included)
└── 📁 src (blue folder icon - Sources Root) ✅
    ├── 📁 module3
    │   └── 📁 concurrency
    │       └── 📁 problems
    │           └── ☕ BuySellDemo.java (has ▶️ play button)
    └── 📁 project
        ├── 📁 utils
        │   ├── ☕ DateTimeUtil.java
        │   ├── ☕ FileWriterUtil.java
        │   └── ☕ LoggerClass.java
        └── 📁 demo
            ├── ☕ LoggerDemo.java (has ▶️ play button)
            └── ☕ PathDemo.java (has ▶️ play button)
```

---

## Compiling from Command Line (Optional)

If you prefer to use the command line:

### Windows PowerShell

```powershell
# From project root, navigate to src
cd src

# Compile all files
javac project\utils\*.java project\demo\*.java

# Run LoggerDemo
java project.demo.LoggerDemo
```

### Mac/Linux

```bash
# From project root
javac src/project/utils/*.java src/project/demo/*.java

# Run LoggerDemo
java -cp src project.demo.LoggerDemo
```

---

## JDK Version Support

| JDK Version | Supported? | Notes                    |
| ----------- | ---------- | ------------------------ |
| JDK 21      | ✅ Yes     | Minimum required version |
| JDK 22      | ✅ Yes     | Fully compatible         |
| JDK 23      | ✅ Yes     | Fully compatible         |
| JDK 24      | ✅ Yes     | Fully compatible         |
| JDK 25      | ✅ Yes     | Fully compatible         |

---

## Need Help?

If you're still having issues:

1. Make sure you have JDK 21 or higher installed
2. Verify `src` folder is marked as Sources Root (blue icon)
3. Invalidate caches: **File** → **Invalidate Caches / Restart**
4. Check the main `README.md` for project documentation

Happy coding! 🚀
