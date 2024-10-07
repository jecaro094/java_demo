## Commands to build and run Java files.

Run this commands from `demo` location in this repository.

### Compile
```bash
javac src/main/java/com/example/Main.java src/main/java/com/example/utils/*.java -d target/classes/
```

### Run
```bash
java -cp target/classes com.example.Main
```

### Run with arguments
```bash
java -cp target/classes com.example.Main 'd' 100 10
```