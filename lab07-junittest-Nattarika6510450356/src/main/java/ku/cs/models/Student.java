package ku.cs.models;

public class Student {
    private String id;
    private String name;
    private double score;

    public Student(String id, String name) { //not test (is a construtor)
        this.id = id;
        this.name = name;
        score = 0;
    }

    public Student(String id, String name, double score) { //not test (is a construtor)
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public void changeName(String name) {
        if (!name.trim().isEmpty()) {
            this.name = name.trim();
        }
    }

    public void addScore(double score) {
        if (score > 0) {
            this.score += score;
        }
    }

    public String grade()
    {
        String grade = "F";
        if (score >= 80){
            grade = "A";
        } else if (score >= 70) {
            grade = "B";
        }else if (score >= 60) {
            grade = "C";
        }else if (score >= 50){
            grade = "D";
        }
        return grade;
    }

    public boolean isId(String id) {
        return this.id.equals(id);
    }

    public String getId() {
        return id;
    } // not test

    public String getName() {
        return name;
    } // not test

    public double getScore() {
        return score;
    } // not test

    @Override
    public String toString() { // not test
        return "{" +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", score: " + score +
                '}';
    }
}