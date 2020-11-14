import { combineReducers } from 'redux'
import notificationReducer from './notificationReducer'
import tagReducer from './tagReducer'
import wordsReducers from './wordsReducers'

export default combineReducers({
  tag: tagReducer,
  notifications: notificationReducer,
  words: wordsReducers,
})
