import isEmpty from 'lodash/isEmpty'
import Validator from 'validator'

//Validate sign-in form
export const validateWordData = data => {
  let errors = {}
  if (Validator.isEmpty(data.word)) {
    errors.word = true
  }
  if (Validator.isEmpty(data.url)) {
    errors.url = true
  }

  return {
    errors,
    isValid: isEmpty(errors),
  }
}

/**
 *
 * @param {string} word
 */

export const validateAlphabetAnSize = word => {
  let errors = {}
  
  if (/[^a-zA-Z]/.test(word)){
    errors.word = true
  } 
  if (word.length > 15) errors.word = true

  return {
    errors,
    isValid: isEmpty(errors),
  }
}

export const validateURL = str => {
  let errors = {}
  var pattern = new RegExp(
    '^(https?:\\/\\/)?' + // protocol
      '((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.)+[a-z]{2,}|' + // domain name
      '((\\d{1,3}\\.){3}\\d{1,3}))' + // OR ip (v4) address
      '(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*' + // port and path
      '(\\?[;&a-z\\d%_.~+=-]*)?' + // query string
      '(\\#[-a-z\\d_]*)?$',
    'i'
  ) // fragment locator
  if (!pattern.test(str)) errors.url=true

  return {
    errors,
    isValid: isEmpty(errors),
  }
}
