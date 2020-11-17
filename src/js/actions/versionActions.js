import Axios from 'axios'
import { GET_VERSION } from './api'
import { FETCH_VERSION } from './types'

export const fetchVersion = () => dispatch => {
  return Axios.get(GET_VERSION).then(tag => {
    dispatch({ type: FETCH_VERSION, payload: tag.data })
  })
}
