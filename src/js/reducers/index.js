import { combineReducers } from 'redux'
import notificationReducer from './notificationReducer'
import tagReducer from './tagReducer'
import versionReducer from './versionReducer'
import wordsReducers from './wordsReducers'

export default combineReducers({
  version: versionReducer,
  tag: tagReducer,
  notifications: notificationReducer,
  words: wordsReducers,
})
