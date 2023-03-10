INSERT INTO subjects (subject_id, subject_name, credits)
VALUES 
(1, 'Mathematics', 4),
(2, 'English', 3),
(3, 'Science', 4),
(4, 'History', 3);

INSERT INTO teachers (teacher_id, teacher_name, teacher_email)
VALUES 
(1, 'John Smith', 'john.smith@example.com'),
(2, 'Jane Doe', 'jane.doe@example.com'),
(3, 'Michael Johnson', 'michael.johnson@example.com');

INSERT INTO classes (class_id, subject_id, class_name, class_start_date, class_end_date)
VALUES 
(1, 1, 'Math 101', '2023-04-01 09:00:00', '2023-06-01 11:00:00'),
(2, 1, 'Math 101 2', '2023-04-02 09:00:00', '2023-06-02 11:00:00'),
(3, 1, 'Math 101 3', '2023-04-03 09:00:00', '2023-06-03 11:00:00'),
(4, 2, 'English 101', '2023-04-01 11:00:00', '2023-06-01 13:00:00'),
(5, 2, 'English 101 2', '2023-04-02 11:00:00', '2023-06-02 13:00:00'),
(6, 2, 'English 101 3', '2023-04-03 11:00:00', '2023-06-03 13:00:00'),
(7, 3, 'Science 101', '2023-04-01 13:00:00', '2023-06-01 15:00:00'),
(8, 3, 'Science 101 2', '2023-04-02 13:00:00', '2023-06-02 15:00:00'),
(9, 3, 'Science 101 3', '2023-04-03 13:00:00', '2023-06-03 15:00:00'),
(10, 4, 'History 101', '2023-04-01 16:00:00', '2023-06-01 18:00:00'),
(11, 4, 'History 101 2', '2023-04-02 16:00:00', '2023-06-02 18:00:00'),
(12, 4, 'History 101 3', '2023-04-03 16:00:00', '2023-06-03 18:00:00');

INSERT INTO class_teachers (class_id, teacher_id)
VALUES 
(1, 1),
(2, 1),
(3, 1),
(4, 2),
(5, 2),
(6, 2),
(7, 3),
(8, 3),
(9, 3),
(10, 1),
(11, 1),
(12, 1);

INSERT INTO students (students_id, students_name, students_email)
VALUES
(1, 'Alice Smith', 'alice.smith@example.com'),
(2, 'Bob Johnson', 'bob.johnson@example.com'),
(3, 'Charlie Brown', 'charlie.brown@example.com'),
(4, 'David Lee', 'david.lee@example.com');

INSERT INTO enrollment (enrollment_id, student_id, subject_id)
VALUES
(1, 1, 1),
(2, 1, 2),
(3, 2, 1),
(4, 2, 3),
(5, 3, 2),
(6, 4, 4);

INSERT INTO exam (exam_id, exam_grade, exam_date, enrollment_id)
VALUES 
(1, 85, '2023-05-01', 1),
(2, 90, '2023-05-02', 2),
(3, 75, '2023-05-03', 3),
(4, 80, '2023-05-04', 4),
(5, 95, '2023-05-05', 5),
(6, 70, '2023-05-06', 6);

INSERT INTO attendance (student_id, class_id)
VALUES
(1,1),
(1,2),
(1,3),
(1,4),
(1,6),
(2,1),
(2,2),
(2,7),
(2,9),
(3,4),
(3,5),
(3,6),
(4,10),
(4,11);