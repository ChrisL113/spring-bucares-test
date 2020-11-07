import { SUCCESS, CLEAR, ERROR, WARNING, INFO } from './types';

export const showSuccessSnackbar = message => {
  return dispatch => {
    dispatch({ type: SUCCESS, message });
  };
};

export const showErrorSnackbar = message => {
  return dispatch => {
    dispatch({ type: ERROR, message });
  };
};
export const showInfoSnackbar = message => {
  return dispatch => {
    dispatch({ type: INFO, message });
  };
};

export const showWarningSnackbar = message => {
  return dispatch => {
    dispatch({ type: WARNING, message });
  };
};
export const clearSnackbar = () => {
  return dispatch => {
    dispatch({ type: CLEAR });
  };
};