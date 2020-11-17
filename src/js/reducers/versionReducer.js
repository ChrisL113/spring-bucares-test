import { FETCH_VERSION } from "../actions/types"

const initialState = {
  item: 'unknown',
}

export default function (state = initialState, action) {
  switch (action.type) {
    case FETCH_VERSION:
      return {
        ...state,
        item: action.payload,
      }

    default:
      return state
  }
}
