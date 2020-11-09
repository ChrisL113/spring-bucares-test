import {  ERASE_URL, FETCH_URLS } from '../actions/types'

const initialState = {
  items: [],
}

export default function (state = initialState, action) {
  switch (action.type) {
    case FETCH_URLS:
      return {
        ...state,
        items: action.payload,
      }
    case ERASE_URL:
      return {
        ...state,
        items: state.items.filter((item, index) => index !== action.payload),
      }

    default:
      return state
  }
}
