import { Button, TextField } from '@material-ui/core'
import PropTypes from 'prop-types'
import React, { Component } from 'react'
import { connect } from 'react-redux'
import {
  showErrorSnackbar,
  showSuccessSnackbar,
} from '../actions/notificationActions'
import { checkWord } from '../actions/wordsActions'
import {
  validateAlphabetAnSize,
  validateURL,
  validateWordData,
} from '../validators/indexValidator'

class IndexInput extends Component {
  constructor() {
    super()
    this.state = {
      url: '',
      word: '',
      errors: '',
      isLoading: false,
    }
  }

  isValidBlank = () => {
    const { errors, isValid } = validateWordData(this.state)

    if (!isValid) {
      this.setState({ errors })
    }

    return isValid
  }
  isValidURL = () => {
    const { errors, isValid } = validateURL(this.state.url)
    if (!isValid) this.setState({ errors })

    return isValid
  }

  isValidWord = () => {
    const { errors, isValid } = validateAlphabetAnSize(this.state.word)
    if (!isValid) this.setState({ errors })

    return isValid
  }

  onChange = e => {
    this.setState({ [e.target.name]: e.target.value })
  }

  onCheck = e => {
    e.preventDefault()
    const wordData = {
      url: this.state.url,
      word: this.state.word.toLowerCase(),
    }
    if (this.isValidBlank()) {
      if (this.isValidURL()) {
        if (this.isValidWord()) {
          this.setState({ errors: {}, isLoading: true })
          this.props.checkWord(wordData).then(res => {
            this.setState({ isLoading: false })
            switch (res.status) {
              case 200:
                if (res.apiRes == 'rejected_url')
                  this.props.showErrorSnackbar('url is already in database')
                else if (res.apiRes == 'rejected_word')
                  this.props.showErrorSnackbar('word is already in database')
                else this.props.showSuccessSnackbar('word saved !')
                break
              default:
                this.props.showErrorSnackbar(res.msg)

                break
            }
          })
        }
      }
    }
  }
  render() {
    return (
      <>
        <div>
          <TextField
            variant='outlined'
            margin='normal'
            // required
            id='url'
            label='URL'
            name='url'
            style={{width:250}}
            helperText={this.state.errors.url ? 'this url is not valid' : ''}
            value={this.state.url}
            error={this.state.errors.url}
            // autoFocus
            onChange={this.onChange}
          />
        </div>
        <div>
          <TextField
            variant='outlined'
            margin='normal'
            // required
            id='word'
            label='word'
            name='word'
            style={{width:250}}
            helperText={
              this.state.errors.word
                ? 'only letters are allowed and no more than 15 characters'
                : ''
            }
            value={this.state.word}
            error={this.state.errors.word}
            // autoFocus
            onChange={this.onChange}
          />
        </div>
        <div style={{ marginTop: '1rem' }}>
          <Button
            type='submit'
            variant='contained'
            color='primary'
            size='large'
            //   disabled={props.isLoading}
            onClick={this.onCheck}
            disabled={this.state.isLoading}
          >
            Submit
          </Button>
        </div>
      </>
    )
  }
}
IndexInput.propTypes = {
  checkWord: PropTypes.func.isRequired,
  showSuccessSnackbar: PropTypes.func.isRequired,
  showErrorSnackbar: PropTypes.func.isRequired,
}
export default connect(null, {
  checkWord,
  showErrorSnackbar,
  showSuccessSnackbar,
})(IndexInput)
