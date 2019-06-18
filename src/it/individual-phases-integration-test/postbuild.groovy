// 1. mvn clean initialize
assert new File(basedir, "target/created-in-initialize-phase.txt").exists()

// 2. mvn compile -P individual-phases
assert !new File(basedir, "target/created-in-process-resources-phase.txt").exists()
assert new File(basedir, "target/created-in-compile-phase.txt").exists()

// 3. mvn prepare-package package -P individual-phases
assert !new File(basedir, "target/created-in-process-classes-phase.txt").exists()
assert !new File(basedir, "target/created-in-test-compile-phase.txt").exists()
assert new File(basedir, "target/created-in-prepare-package-phase.txt").exists()
assert new File(basedir, "target/created-in-package-phase.txt").exists()