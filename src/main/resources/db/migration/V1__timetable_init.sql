CREATE TABLE timetable_table (
        id       SERIAL PRIMARY KEY,

        day            varchar (50),
        academic_class_id  bigint,
        course_id  bigint[]
);
