// Declare a error message variable globally
let errorMessageToBeDisplayed = 'Please enter valid ';


//check for validate email
function ValidateEmail(email){
    var regex = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\.[a-zA-Z0-9-]+)*$/;
    let isValid = regex.test(email)
    if(!isValid){
        errorMessageToBeDisplayed += 'Email ID '
        var em=document.getElementById('input-email')
        em.style.border="solid 3px red";
        return false;
    }
    return isValid;
}
//Check validate website
function ValidateWebsite(website){
    var expression1 = /(http(s)?:\/\/.)?(www\.)?[-a-zA-Z0-9@:%._\+~#=]{2,256}\.[a-z]{2,6}\b([-a-zA-Z0-9@:%_\+.~#?&//=]*)/g  ;
    var expression2 =  /^http:\/\/\w+(\.\w+)*(:[0-9]+)?\/?(\/[.\w]*)*$/;
    
    let isValid = expression1.test(website) || expression2.test(website)

    if(!isValid){
        errorMessageToBeDisplayed += 'Website Link '
        var web=document.getElementById('input-website')
        web.style.border="solid 3px red";
        return false;
    }
    return isValid;
}
// Check for validate name
function ValidateName(name){
    // used regular expression
    var regex = /^[a-zA-Z ]{2,30}$/;
    // gives boolean value
    let isValid = regex.test(name)
    if(!isValid){
        //if error occurs
        errorMessageToBeDisplayed += 'Name '
        //for border 
        var uname=document.getElementById('input-name')
        uname.style.border="solid 3px red";
        return false;
    }
    return true;
}
function EnrollStudent(student){

    let newStudentEntry = document.createElement('li');


    let evenOrOdd = 'odd';
    let enrolledStudents = document.querySelectorAll("#studentsList")[0].children;
    if((enrolledStudents.length + 1) % 2 === 0){
        evenOrOdd = 'even'
    }
   //jsx used  
    newStudentEntry.innerHTML = `<div class="tableEntery row ${evenOrOdd} fade-in">
                                    <div class="studentDetails item col-xs-8" style="padding-top:1em">
                                        <span  id="studentName" >${student.name}</span>
                                        <span  id="gender">${student.gender}</span>
                                        <span  id="emailId">${student.email}</span>
                                        <span id="website"><a href="//${student.website}" target="_blank">${student.website}</a></span>
                                        <span  id="skills">${student.skills}</span>
                                    </div>

                                    <div class="studentImage item col-xs-4">   
                                        <img src="${student.image}" alt="Student Image">
                                    </div>
                                </div>`
                                //all datat stored in a list
    document.getElementById('studentsList').appendChild(newStudentEntry);
    document.getElementById('studentsTable').style.visibility = 'visible';
}

function ValidateForm(student){
    var isNameValid = ValidateName(student.name);
    var isEmailValid = ValidateEmail(student.email);
    var isWebsiteValid = true;
 //if website link is entered
    if(student.website != ''){
        isWebsiteValid = ValidateWebsite(student.website)
    }
    //get error stored in varaible
    let errorMessage = document.getElementById('error-mssg');
    //if all fields are valid
    if(isNameValid && isEmailValid && isWebsiteValid){
        errorMessage.innerText = '';
        errorMessage.style.display = 'none';
        errorMessageToBeDisplayed = ''
        return true;
    }
    //if errror occurs
    errorMessage.innerText = errorMessageToBeDisplayed;
    //display hidden message
    errorMessage.style.display = 'block';
    return false;
}
//on form submit
function onFormSubmit(e){
    e.preventDefault();
    // create objext 
    let studentObj = new Object;
    //values stored in an object
    studentObj.name = document.getElementById('input-name').value;
    studentObj.email = document.getElementById('input-email').value;
    studentObj.website = document.getElementById('input-website').value;
    studentObj.image = document.getElementById('input-image').value;
   // check if user enter image link or not if not then use default image
    if(studentObj.image === ''){
        studentObj.image = 'https://i.pinimg.com/originals/3f/94/70/3f9470b34a8e3f526dbdb022f9f19cf7.jpg';
    }
  
    studentObj.gender = document.getElementsByName('gender');
    studentObj.skills = document.getElementsByName('skills');
    // access values of radio and checkbox by for loop
    let result = '';
    for(let i = 0; i < studentObj.gender.length; i++){
        if(studentObj.gender[i].checked){
            result = studentObj.gender[i].value;
        }
    }
    studentObj.gender = result;

    result = '';
    for(let i = 0; i < studentObj.skills.length; i++){
        if(studentObj.skills[i].checked){
            result += studentObj.skills[i].value +' ';
        }
    }
    studentObj.skills = result;
    //error message
    errorMessageToBeDisplayed = 'Please enter valid ';
    //if true-> enrolled and reset
    if(ValidateForm(studentObj)){
        EnrollStudent(studentObj);
        document.getElementById('enrollmentForm').reset();
    }
    

    
}
const enrollForm = document.querySelector("#enrollmentForm");
enrollForm.addEventListener('submit',onFormSubmit);