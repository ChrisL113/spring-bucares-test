import { CLEAR, ERROR, INFO, SUCCESS, WARNING } from '../actions/types'

const initialState = {
  snackbarOpen: false,
  snackbarStatus: 'info',
  snackbarMessage: '',
}

export default function (state = initialState, action) {
  switch (action.type) {
    case SUCCESS:
      return {
        ...state,
        snackbarOpen: true,
        snackbarStatus: 'success',
        snackbarMessage: action.message,
      }
    case ERROR:
      return {
        ...state,
        snackbarOpen: true,
        snackbarStatus: 'error',
        snackbarMessage: action.message,
      }
    case WARNING:
      return {
        ...state,
        snackbarOpen: true,
        snackbarStatus: 'warning',
        snackbarMessage: action.message,
      }
    case INFO:
      return {
        ...state,
        snackbarOpen: true,
        snackbarStatus: 'info',
        snackbarMessage: action.message,
      }
    case CLEAR:
      return {
        ...state,
        snackbarOpen: false,
        snackbarStatus: 'info',
        snackbarMessage: '',
      }
    default:
      return state
  }
}
