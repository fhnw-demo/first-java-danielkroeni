// java --enable-preview --source 21 src/Example.java

record Student(int matrikel, double grade) {}

void main() {
    var s = new Student(123456, 4.5);

    if(s.grade() < 4) {
        

        System.out.println("Try harder");
    } else {
        System.out.println("Keep going");
    }
}