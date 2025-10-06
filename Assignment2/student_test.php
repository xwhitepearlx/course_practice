<!DOCTYPE html>
<html>
<body>

<?php
class Person {
  private $name;
  private $age;

  public function __construct($name,$age)
  {
    $this->name = $name;
    $this->age = $age;
  }
  public function __toString()
  {
    return "Person: {$this->name}, Age: {$this->age}";
  }
}

class Student extends Person {
    private $studentID;
    private $major;

    public function __construct($name,$age,$studentID,$major) {
        parent::__construct($name,$age);
        $this->studentID = $studentID;
        $this->major = $major;
    }
    public function __toString()
    {
         return parent::__toString() . ", Student ID: {$this->studentID}, Major: {$this->major}";
    }
}

function infoSave($obj,$write,$name){
    $txt = "Object name: {$name} \n";
    fwrite($write,$txt);
    $txt = $obj . ".\n";
    fwrite($write, $txt);
    date_default_timezone_set("America/Vancouver");
    $txt = "Date: ". date("F j, Y") ." Time: ".date("h:i:sa")." (Vancouver local time).\n\n";
    fwrite($write, $txt);
}

$student1 = new Student("Alice", 21, "S123", "Computer Science");
echo $student1."<br>";
$student2 = new Student("Charles", 24, "E123", "Computer Engineer");
echo $student2."<br><br>";
echo "Data has been successfully saved to \"student_log.txt\"";

$myfile = fopen("student_log.txt","w");
infoSave($student1,$myfile,"student1");
infoSave($student2,$myfile,"student2");
fclose($myfile);
?>
 
</body>
</html>