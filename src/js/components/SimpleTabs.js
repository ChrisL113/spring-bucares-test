import { Chip } from '@material-ui/core'
import AppBar from '@material-ui/core/AppBar'
import Box from '@material-ui/core/Box'
import { makeStyles } from '@material-ui/core/styles'
import Tab from '@material-ui/core/Tab'
import Tabs from '@material-ui/core/Tabs'
import PropTypes from 'prop-types'
import React, { useEffect } from 'react'
import { useDispatch, useSelector } from 'react-redux'
import { fetchTag } from '../actions/tagActions'
import { fetchVersion } from '../actions/versionActions'
import IndexInput from './IndexInput'
import ListIndices from './ListIndices'

const TabPanel = props => {
  const { children, value, index, ...other } = props

  return (
    <div
      role='tabpanel'
      hidden={value !== index}
      id={`simple-tabpanel-${index}`}
      aria-labelledby={`simple-tab-${index}`}
      {...other}
    >
      {value === index && <Box p={3}>{children}</Box>}
    </div>
  )
}

TabPanel.propTypes = {
  children: PropTypes.node,
  index: PropTypes.any.isRequired,
  value: PropTypes.any.isRequired,
}

function a11yProps(index) {
  return {
    id: `simple-tab-${index}`,
    'aria-controls': `simple-tabpanel-${index}`,
  }
}

const useStyles = makeStyles(theme => ({
  root: {
    flexGrow: 1,
    backgroundColor: theme.palette.background.paper,
  },
  tag: {
    position: "fixed",
    bottom: 10,
    right:0,
  }
}))

const SimpleTabs = () => {
  const classes = useStyles()
  const dispatch = useDispatch()
  const [value, setValue] = React.useState(0)
  const tag = useSelector(state => state.tag.item)
  const version = useSelector(state => state.version.item)
  useEffect(() => {
    dispatch(fetchTag())
    dispatch(fetchVersion())
  }, [])

  const handleChange = (event, newValue) => {
    setValue(newValue)
  }

  return (
    <div className={classes.root}>
      <AppBar position='static'>
        <Tabs
          value={value}
          onChange={handleChange}
          aria-label='simple tabs example'
        >
          <Tab label='Index Form' {...a11yProps(0)} />
          <Tab label='Indices' {...a11yProps(1)} />
        </Tabs>
      </AppBar>
      <TabPanel value={value} index={0}>
        <IndexInput />
      </TabPanel>
      <TabPanel value={value} index={1}>
        <ListIndices />
      </TabPanel>
      <Chip className={classes.tag} label={"Instance: "+tag + ", Version: "+ version} color='primary' />
    </div>
  )
}

export default SimpleTabs
