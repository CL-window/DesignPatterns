import java.util.*;
public class Prototype {

    public static class Subject {
        private String name;
        public Subject(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "[Subject: " + this.hashCode() + ",name:" + name + "]";
        }

    }

    public static class PrototypeClone implements Cloneable {

        //引用类型
        private Subject subject;
        //基础数据类型
        public String name;
        public PrototypeClone() {
            System.out.println("PrototypeClone...");
        }

        public Subject getSubject() {
            return subject;
        }
    
        public void setSubject(Subject subject) {
            this.subject = subject;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println(this.toString());
        }

        // 浅拷贝 Subject 修改一起修改
        //[PrototypeClone: 2018699554,subject: [Subject: 1311053135,name:slack],name: slack1]
        //[PrototypeClone: 118352462,subject: [Subject: 1311053135,name:name1],name: name]
        //[PrototypeClone: 2018699554,subject: [Subject: 1311053135,name:name1],name: slack1]
        // @Override
        protected PrototypeClone clone() throws CloneNotSupportedException {
            // TODO Auto-generated method stub
            System.out.println("PrototypeClone clone...");
            return (PrototypeClone) super.clone();
        }

        @Override
        public String toString() {
            return "[PrototypeClone: " + this.hashCode() + ",subject: " + subject + ",name: " + name + "]";
        }
    }

    
    /**
     * 
     * [PrototypeClone: 2018699554,subject: [Subject: 1311053135,name:slack],name: slack1]
     * [PrototypeClone: 118352462,subject: [Subject: 1311053135,name:name1],name: name]
     * [PrototypeClone: 2018699554,subject: [Subject: 1311053135,name:name1],name: slack1]
     */
    private void shallowCopy() {
        PrototypeClone clone = new PrototypeClone();
        Subject subject = new Subject("slack");
        clone.setSubject(subject);
        clone.setName("slack1");
        clone.print();
        
        try {
            PrototypeClone cloneObject = clone.clone();
            cloneObject.setName("name");
            Subject subjectB = cloneObject.getSubject();
            subjectB.setName("name1");
            cloneObject.print();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }

        clone.print();
    }

    public static class SubjectClone implements Cloneable  {
        private String name;
        public SubjectClone(String name) {
            this.name = name;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "[SubjectClone: " + this.hashCode() + ",name:" + name + "]";
        }

        protected SubjectClone clone() throws CloneNotSupportedException {
            return (SubjectClone) super.clone();
        }
    }

    public static class PrototypeClone2 implements Cloneable {

        //引用类型
        private SubjectClone subject;
        //基础数据类型
        public String name;
        public PrototypeClone2() {
            System.out.println("PrototypeClone2...");
        }

        public SubjectClone getSubject() {
            return subject;
        }
    
        public void setSubject(SubjectClone subject) {
            this.subject = subject;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }

        public void print() {
            System.out.println(this.toString());
        }

        // 深拷贝
        @Override
        protected PrototypeClone2 clone() throws CloneNotSupportedException {
            // TODO Auto-generated method stub
            // 直接调用父类的clone()方法
            PrototypeClone2 pClone = (PrototypeClone2) super.clone();
            pClone.subject = (SubjectClone) pClone.subject.clone();
            return pClone;
        }

        @Override
        public String toString() {
            return "[PrototypeClone: " + this.hashCode() + ",subject: " + subject + ",name: " + name + "]";
        }
    }

    /**
     * [PrototypeClone: 1550089733,subject: [SubjectClone: 865113938,name:slack],name: slack1]
     * [PrototypeClone: 1442407170,subject: [SubjectClone: 1028566121,name:name1],name: name]
     * [PrototypeClone: 1550089733,subject: [SubjectClone: 865113938,name:slack],name: slack1]
     */
    private void deepCopy() {
        PrototypeClone2 clone = new PrototypeClone2();
        SubjectClone subject = new SubjectClone("slack");
        clone.setSubject(subject);
        clone.setName("slack1");
        clone.print();
        
        try {
            PrototypeClone2 cloneObject = clone.clone();
            cloneObject.setName("name");
            SubjectClone subjectB = cloneObject.getSubject();
            subjectB.setName("name1");
            cloneObject.print();
        } catch(CloneNotSupportedException e) {
            e.printStackTrace();
        }

        clone.print();
    }

    public static void main(String[] args) {
        Prototype prototype = new Prototype();
        prototype.shallowCopy();
        System.out.println("------------------");
        prototype.deepCopy();
    }
}