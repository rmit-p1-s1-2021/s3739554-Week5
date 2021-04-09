package timetable;

public class TimetableSystem 
{
    private Activity[] activities;
    private Student[] students;
    
    public TimetableSystem()
    {
        activities = new Activity[]
        {
            new Activity(1, "Programming 1 - Lectorial 1", "Tuesday 2:30pm"),
            new Activity(2, "Programming 1 - Lectorial 2", "Thursday 2:30pm"),
            new Activity(3, "Programming 1 - Practical 1", "Tuesday 8:30am"),
        };
        
        students = new Student[]
        {
            new Student("s1234567", "Bob"),
            new Student("s2345678", "Bill"),
            new Student("s3456789", "Alice")
        };
        
        activities[0].addStudent(students[0]);
        activities[1].addStudent(students[0]);
        activities[0].addStudent(students[1]);
    }
    
    public Activity[] getActivities()
    {
        return activities;
    }
    
    public Student[] getStudents()
    {
        return students;
    }
    
    public Activity getActivity(int id)
    {
        for(int i = 0; i < activities.length; i++)
        {
            if(activities[i].getId() == id)
                return activities[i];
        }
        
        return null;
    }
    
    public Student getStudent(String id)
    {
        for(int i = 0; i < students.length; i++)
        {
            if(students[i].getId().equals(id))
                return students[i];
        }
        
        return null;
    }
}
