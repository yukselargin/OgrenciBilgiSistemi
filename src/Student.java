public class Student {
    Course mat;
    Course fizik;
    Course kimya;
    Course coNote;
    Course coViNote;
    String name,stuNo;
    int classes;
    double avarage;
    double fizikAv;
    double kimAv;
    double matAv;
    boolean isPass;


    Student(String name, int classes, String stuNo, Course mat,Course fizik,Course kimya) {
        this.name = name;
        this.classes = classes;
        this.stuNo = stuNo;
        this.mat = mat;
        this.fizik = fizik;
        this.kimya = kimya;
        calcAvarage();
        this.isPass = false;
    }


    public void addBulkExamNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.note = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.note = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.note = kimya;
        }

    }
    public void addBulkViNote(int mat, int fizik, int kimya) {

        if (mat >= 0 && mat <= 100) {
            this.mat.viNote = mat;
        }

        if (fizik >= 0 && fizik <= 100) {
            this.fizik.viNote = fizik;
        }

        if (kimya >= 0 && kimya <= 100) {
            this.kimya.viNote = kimya;
        }

    }


    public void isPass() {
        if (this.mat.note == 0 || this.fizik.note == 0 || this.kimya.note == 0) {
            System.out.println("Notlar tam olarak girilmemiş");
        } else {
            this.isPass = isCheckPass();
            printNote();
            System.out.println("Ortalama : " + this.avarage);
            if (this.isPass) {
                System.out.println("Sınıfı Geçti. ");
            } else {
                System.out.println("Sınıfta Kaldı.");
            }
        }
    }

    public void calcAvarage() {
        this.fizikAv= (this.fizik.note *this.fizik.coNote)+(this.fizik.viNote*this.fizik.coViNote);
        this.kimAv= (this.kimya.note *this.kimya.coNote)+(this.kimya.viNote*this.kimya.coViNote);
        this.matAv= (this.mat.note *this.mat.coNote)+(this.mat.viNote*this.mat.coViNote);
        this.avarage =(this.fizikAv+this.kimAv+this.matAv)/3;
    }

    public boolean isCheckPass() {
        calcAvarage();
        return this.avarage > 55;
    }

    public void printNote(){
        System.out.println("=========================");
        System.out.println("Öğrenci : " + this.name);
        System.out.println("Matematik Notu : " + this.mat.note);
        System.out.println("Fizik Notu : " + this.fizik.note);
        System.out.println("Kimya Notu : " + this.kimya.note);
    }

}
