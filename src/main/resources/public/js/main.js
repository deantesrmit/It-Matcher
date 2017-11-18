function checkpassword(input) {
    var reg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{6,}/;
    if ( reg.test(input.value) == false) {
        input.setCustomValidity('Password Must contain at least one number and one uppercase and lowercase letter, and at least 6 or more characters');
        return false;
    } else {

        input.setCustomValidity('');
        return true;
    }
}

function check(input) {
    if (checkpassword(input) == true) {
        if (input.value != document.getElementById('userPassword').value) {
            input.setCustomValidity('Password Must be Matching.');
        } else {

            input.setCustomValidity('');
        }
    }
}

function checkname(input) {
    var reg = /^[A-Za-z ]+$/;
    if ( reg.test(input.value) == false) {
        input.setCustomValidity('characters only');
        return false;
    } else {

        input.setCustomValidity('');
        return true;
    }
}
function check_number_character(input) {
    var reg = /^[a-z0-9 ]+$/i;
    if ( reg.test(input.value) == false) {
        input.setCustomValidity('characters and numbers only');
        return false;
    } else {

        input.setCustomValidity('');
        return true;
    }
}

function check_number_only(input) {
    var reg = /^[0-9]+$/;
    if ( reg.test(input.value) == false) {
        input.setCustomValidity('numbers only');
        return false;
    } else {

        input.setCustomValidity('');
        return true;
    }
}