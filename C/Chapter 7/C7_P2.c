/* C7_P2.c
   Author: Billy Hart      Last Modified by: Billy Hart
   Assignment: Chapter 7 Project #2
   Date Last Modified: November 7, 2015
   Program Description:
   A list of student objects are retrieved and printed, sorted by last name,
   with an average of 3 test scores displayed on the same line.
*/


/* --------------------------------- Includes ---------------------------------- */

#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/* ---------------------------- Function Prototypes ---------------------------- */

// Main
void   printStudentStruct();

// Tools
int    compareStudentLastName (const void *, const void *);
double CalculateAverageScore(double scoresToAverage[], int size);



/* -------------------------------- Definitions -------------------------------- */

#define Array_Length(arrayToCheck) (sizeof(arrayToCheck) / sizeof(arrayToCheck[0]))


/* ------------------ Global Declarations && Structure Design ------------------ */

// Constants
const int Num_Of_Students = 10;
const int Max_LastName_Length = 15;

// Structure Declaration 
struct Student { 
  int  testScore1;
  int  testScore2;
  int  testScore3;
  char lastName[Max_LastName_Length];
};

// Structure Initialization 
struct Student listOfStudents[Num_Of_Students] = { 
  {  1, 12, 14, "Smith"     },
  { 50, 41, 23, "Johnson"   },
  { 80, 47, 99, "Williams"  },
  {  4, 10, 92, "Brown"     },
  {  3, 88, 31, "Jones"     },
  {  9, 91, 14, "Miller"    },
  { 82, 17, 21, "Davis"     },
  { 96, 28, 47, "Garcia"    },
  { 10, 54, 19, "Rodriguez" },
  { 97, 49, 13, "Wilson"    }
}; 

/* ----------------------------------- Main ------------------------------------ */

int main() {

  // Sort the student structure
  qsort(listOfStudents,              // Array to sort
        Num_Of_Students,             // Number of Array elements
        sizeof(struct Student),      // Size of individual structures
        compareStudentLastName);     // Comparator function pointer

  // Print the student structure table
  printStudentStruct();

  // Return and exit
  return (0);
}


/* --------------------------------- Functions --------------------------------- */

// Prints the student structure table
void printStudentStruct() {
  // Local Variables
  int loopCounter;
  double scores[3];
  double studentAverageScore;
  
  // Print table header
  printf("Student      Test Score Average\n");
  printf("-------      ------------------\n");

  // Loop through the structure student array
  for (loopCounter = 0; loopCounter < Num_Of_Students; loopCounter++) {

     // Print the Last Name [Tab]
     printf("%s      ", listOfStudents[loopCounter].lastName);

     // Store the test scores in a local array
     scores[0] = listOfStudents[loopCounter].testScore1;
     scores[1] = listOfStudents[loopCounter].testScore2;
     scores[2] = listOfStudents[loopCounter].testScore3;

     // Calculate the test scores average
     studentAverageScore = CalculateAverageScore(scores, 
                           Array_Length(scores));
     printf("%6.1f%%\n", studentAverageScore);
  }
}


// Compare two last name strings
int compareStudentLastName (const void *element1, const void *element2) {
    // Cast pointers as student struct types. 
    struct Student *Student1 = (struct Student *)element1;
    struct Student *Student2 = (struct Student *)element2;
    
    // Return comparison result
    return strcmp(Student1->lastName, Student2->lastName);
}


// Calculate the average test score from student structure
double CalculateAverageScore(double scoresToAverage[], int size) {
  // Local variables
  int loopCounter;
  double total = 0.0;

  // Cycle through the array, summing each element
  for (loopCounter = 0; loopCounter < size; loopCounter++) {
    total += scoresToAverage[loopCounter];
  }

  // Return the average
  return (total / size);
}

/* ---------------------------- Compile Run Results ---------------------------- */
Student      Test Score Average
-------      ------------------
Brown              35.3%
Davis              40.0%
Garcia             57.0%
Johnson            38.0%
Jones              40.7%
Miller             38.0%
Rodriguez          27.7%
Smith               9.0%
Williams           75.3%
Wilson             53.0%

[Finished in 0.1s]
    