import { combineReducers } from 'redux'
import notificationReducer from './notificationReducer'
import wordsReducers from './wordsReducers'

export default combineReducers({
  notifications: notificationReducer,
  words: wordsReducers,
})
