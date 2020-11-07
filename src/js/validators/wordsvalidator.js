import Validator from 'validator'
import isEmpty from 'lodash/isEmpty'

//Validate sign-in form
export const validateWordData = data => {
  let errors = {};
  if (Validator.isEmpty(data.word)) {
    errors.word = true;
  }
  if (Validator.isEmpty(data.url)) {
    errors.url = true;
  }

  return {
    errors,
    isValid: isEmpty(errors),
  }
};

